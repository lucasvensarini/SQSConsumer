package br.com.lcv.erro;

public class Erro {

	private String jsonObjeto;
	private String mensagem;
	
	public Erro(String jsonObjeto, String mensagem) {
		this.jsonObjeto = jsonObjeto;
		this.mensagem = mensagem;
	}
	
	public String getJsonObjeto() {
		return jsonObjeto;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
}
