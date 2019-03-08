package br.com.lcv.hotel;

import br.com.lcv.model.InfoBase;

public class InfoEmissaoHotel {

	private InfoBase infoBase;
	private String nomeHotel;

	public InfoEmissaoHotel() {
		
	}
	
	public InfoEmissaoHotel(InfoBase infoBase, String nomeHotel) {
		this.infoBase = infoBase;
		this.nomeHotel = nomeHotel;
	}
	
	public InfoBase getInfoBase() {
		return infoBase;
	}

	public void setInfoBase(InfoBase infoBase) {
		this.infoBase = infoBase;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}
	
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	
}
