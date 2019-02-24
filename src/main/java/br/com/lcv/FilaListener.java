package br.com.lcv;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FilaListener {
	
	private FactoryService factoryService;
	
	@Autowired
	public FilaListener(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

    @JmsListener(destination = "teste")
    public void messageConsumer(@Headers Map<String, Object> messageAttributes, @Payload String message) {
    	factoryService.direcionaEmail(messageAttributes, message);
    }
	
}
