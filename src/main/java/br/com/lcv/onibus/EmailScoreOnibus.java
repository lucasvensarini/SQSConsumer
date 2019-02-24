package br.com.lcv.onibus;

import br.com.lcv.model.EmailBase;

public class EmailScoreOnibus {
	
	private EmailBase emailBase;
	private int score;
	
	public EmailScoreOnibus() {
		
	}
	
	public EmailScoreOnibus(EmailBase emailBase, int score) {
		this.emailBase = emailBase;
		this.score = score;
	}
	
	public EmailBase getEmailBase() {
		return emailBase;
	}
	
	public void setEmailBase(EmailBase emailBase) {
		this.emailBase = emailBase;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

}
