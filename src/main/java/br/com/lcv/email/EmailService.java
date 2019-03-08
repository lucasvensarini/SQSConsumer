package br.com.lcv.email;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {

	private Configuration configuration;
	private AmazonSimpleEmailService amazonSimpleEmailService;

	@Autowired
	public EmailService(Configuration configuration, AmazonSimpleEmailService amazonSimpleEmailService) {
		this.configuration = configuration;
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}
	
	public String montaCorpoEmail(Map<String, Object> model, String nomeTemplate) {
		String corpo = "";
		
		try {
	        Template template = configuration.getTemplate(nomeTemplate + ".ftl");
			corpo = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		
		return corpo;
	}

	public void enviaEmail(Email email) {
		SendEmailRequest sendEmailRequest = new SendEmailRequest();

		sendEmailRequest.setSource(email.getDe());
		sendEmailRequest.setDestination(criaDestination(email));
		sendEmailRequest.setMessage(criaMMessage(email));

		amazonSimpleEmailService.sendEmail(sendEmailRequest);
	}

	private Destination criaDestination(Email email) {
		Destination destination = new Destination();
		
		destination.setToAddresses(email.getPara());

		if (email.getCc() != null && !email.getCc().isEmpty()) {
			destination.setCcAddresses(email.getCc());
		}
		
		return destination;
	}
	
	private Message criaMMessage(Email email) {
		Message message = new Message();
		
		String charset = "UTF-8";
		
		Content content = new Content();
		content.setCharset(charset);
		content.setData(email.getAssunto());
		message.setSubject(content);

		Body body = new Body();
		Content htmlContent = new Content();
		htmlContent.setCharset(charset);
		htmlContent.setData(email.getCorpo());
		body.setHtml(htmlContent);
		message.setBody(body);
		
		return message;
	}

}
