package br.com.lcv.hotel;

import br.com.lcv.model.EmailBase;

public class EmailEmissaoHotel {

	private EmailBase emailBase;
	private String nomeHotel;

	public EmailEmissaoHotel() {
		
	}
	
	public EmailEmissaoHotel(EmailBase emailBase, String nomeHotel) {
		this.emailBase = emailBase;
		this.nomeHotel = nomeHotel;
	}
	
	public EmailBase getEmailBase() {
		return emailBase;
	}
	
	public void setEmailBase(EmailBase emailBase) {
		this.emailBase = emailBase;
	}
	
	public String getNomeHotel() {
		return nomeHotel;
	}
	
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	
}
