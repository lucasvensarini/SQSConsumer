package br.com.lcv;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

@SpringBootApplication
@EnableJms
public class SQSConsumerMain {

	private AWSProperties awsProperties;
	private SQSConnectionFactory connectionFactory;

	@Autowired
	public SQSConsumerMain(AWSProperties awsProperties) {
		this.awsProperties = awsProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(SQSConsumerMain.class, args);
	}

	@PostConstruct
	public void init() {
		connectionFactory = new SQSConnectionFactory(new ProviderConfiguration(), defaultAmazonSQS());
	}

	@Bean
	public AmazonSQS defaultAmazonSQS() {
		return AmazonSQSClient.builder().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(criaAWSCredentials())).build();
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}

	@Bean
	public JmsTemplate defaultJmsTemplate() {
		return new JmsTemplate(connectionFactory);
	}
	
	private AWSCredentials criaAWSCredentials() {
		return new BasicAWSCredentials(awsProperties.getId(), awsProperties.getPassword());
	}

}
