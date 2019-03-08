package br.com.lcv;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sqs")
public class SQSProperties {

	private String filaTesteErroUrl;

	public String getFilaTesteErroUrl() {
		return filaTesteErroUrl;
	}

	public void setFilaTesteErroUrl(String filaTesteErroUrl) {
		this.filaTesteErroUrl = filaTesteErroUrl;
	}

}
