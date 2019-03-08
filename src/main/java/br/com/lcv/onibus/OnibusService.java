package br.com.lcv.onibus;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lcv.email.Email;
import br.com.lcv.email.EmailService;
import br.com.lcv.erro.ErroService;

@Service
public class OnibusService {

	private static final String ONIBUS_FOLDER = "/onibus/";

	private ErroService erroService;
	private ObjectMapper objectMapper;
	private EmailService emailService;

	@Autowired
	public OnibusService(ErroService erroService, ObjectMapper objectMapper, EmailService emailService) {
		this.erroService = erroService;
		this.objectMapper = objectMapper;
		this.emailService = emailService;
	}

	public void enviaEmailScore(String message) {
		try {
			InfoScoreOnibus infoScoreOnibus = objectMapper.readValue(message, InfoScoreOnibus.class);
			if (infoScoreOnibus.getInfoBase().getLoc().isEmpty()) {
				erroService.enviaParaFilaErro(message, "Loc vazio");
			} else {
				emailService.enviaEmail(criaEmail(infoScoreOnibus));
			}
		} catch (IOException e) {
			erroService.enviaParaFilaErro(message, "Erro de parse");
		}
	}

	private Email criaEmail(InfoScoreOnibus infoScoreOnibus) {
		String de = "";
		List<String> para = Arrays.asList("");
		String assunto = "Score Ônibus";

		Map<String, Object> model = new HashMap<>();
		model.put("loc", infoScoreOnibus.getInfoBase().getLoc());
		model.put("score", infoScoreOnibus.getScore());

		String corpo = emailService.montaCorpoEmail(model, ONIBUS_FOLDER + "score");

		return new Email(de, para, assunto, corpo);
	}

}
