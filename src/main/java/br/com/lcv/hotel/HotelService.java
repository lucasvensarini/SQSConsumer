package br.com.lcv.hotel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lcv.erro.ErroService;

@Service
public class HotelService {
	
	private ErroService erroService;
	private ObjectMapper objectMapper;

	@Autowired
	public HotelService(ErroService erroService, ObjectMapper objectMapper) {
		this.erroService = erroService;
		this.objectMapper = objectMapper;
	}
	
	public void enviaEmailEmissao(String message) throws IOException {
		
		EmailEmissaoHotel emailEmissaoHotel = objectMapper.readValue(message, EmailEmissaoHotel.class);

        System.out.println("Body: " + emailEmissaoHotel.getEmailBase().getLoc() + " " + emailEmissaoHotel.getNomeHotel());
	}
	
}
