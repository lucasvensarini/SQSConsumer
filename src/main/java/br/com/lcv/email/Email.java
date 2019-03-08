package br.com.lcv.email;

import java.util.List;

public class Email {

	private String de;
	private List<String> para;
	private List<String> cc;
	private String assunto;
	private String corpo;
	
	public Email(String de, List<String> para, String assunto, String corpo) {
		this.de = de;
		this.para = para;
		this.assunto = assunto;
		this.corpo = corpo;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getDe() {
		return de;
	}

	public List<String> getPara() {
		return para;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getCorpo() {
		return corpo;
	}
	
}
