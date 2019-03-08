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
	
	public void enviaEmailEmissao(String message) {
		try {
			InfoEmissaoHotel infoEmissaoHotel = objectMapper.readValue(message, InfoEmissaoHotel.class);
			System.out.println("Body: " + infoEmissaoHotel.getInfoBase().getLoc() + " " + infoEmissaoHotel.getNomeHotel());
		} catch (IOException e) {
			erroService.enviaParaFilaErro(message, "Erro de parse");
		}
	}
	
}
