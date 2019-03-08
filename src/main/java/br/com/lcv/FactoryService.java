package br.com.lcv;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lcv.hotel.HotelService;
import br.com.lcv.model.Produto;
import br.com.lcv.model.TipoEmail;
import br.com.lcv.onibus.OnibusService;

@Service
public class FactoryService {

	private HotelService hotelService;
	private OnibusService onibusService;

	@Autowired
	public FactoryService(HotelService hotelService, OnibusService onibusService) {
		this.hotelService = hotelService;
		this.onibusService = onibusService;
	}

	public void direcionaEmail(Map<String, Object> messageAttributes, String message) {
		String produto = (String) messageAttributes.get("produto");
		String tipoEmail = (String) messageAttributes.get("tipoEmail");

		if (Produto.HOTEL.toString().equalsIgnoreCase(produto)) {
			if (TipoEmail.EMISSAO.toString().equalsIgnoreCase(tipoEmail)) {
				hotelService.enviaEmailEmissao(message);
			}
		} else if (Produto.ONIBUS.toString().equalsIgnoreCase(produto)) {
			if (TipoEmail.SCORE.toString().equalsIgnoreCase(tipoEmail)) {
				onibusService.enviaEmailScore(message);
			}
		}
	}

}
