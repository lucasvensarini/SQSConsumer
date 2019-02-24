package br.com.lcv.erro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lcv.SQSProperties;

@Service
public class ErroService {

	private SQSProperties sqsProperties;
	private ObjectMapper objectMapper;
	private AmazonSQS amazonSQS;
	
	@Autowired
	public ErroService(SQSProperties sqsProperties, ObjectMapper objectMapper, AmazonSQS amazonSQS) {
		this.sqsProperties = sqsProperties;
		this.objectMapper = objectMapper;
		this.amazonSQS = amazonSQS;
	}
	
	public void enviaParaFilaErro(String message, String mensagemErro) throws JsonProcessingException {
		SendMessageRequest sendMessageRequest = new SendMessageRequest();
		
		Erro erro = new Erro(message, mensagemErro);
		String erroJson = objectMapper.writeValueAsString(erro);
		
		sendMessageRequest.setQueueUrl(sqsProperties.getFilaTesteErroUrl());
		sendMessageRequest.setMessageBody(erroJson);
		
		amazonSQS.sendMessage(sendMessageRequest);
	}
	
}
