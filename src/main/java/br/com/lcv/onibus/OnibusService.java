package br.com.lcv.onibus;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lcv.erro.ErroService;

@Service
public class OnibusService {

	private ErroService erroService;
	private ObjectMapper objectMapper;

	@Autowired
	public OnibusService(ErroService erroService, ObjectMapper objectMapper) {
		this.erroService = erroService;
		this.objectMapper = objectMapper;
	}
	
	public void enviaEmailScore(String message) throws IOException {
		EmailScoreOnibus emailScoreOnibus = objectMapper.readValue(message, EmailScoreOnibus.class);

		if (emailScoreOnibus.getEmailBase().getLoc().isEmpty()) {
			erroService.enviaParaFilaErro(message, "Loc vazio");
		} else {
			System.out.println("Body: " + emailScoreOnibus.getEmailBase().getLoc() + " " + emailScoreOnibus.getScore());			
		}	
	}
	
}
