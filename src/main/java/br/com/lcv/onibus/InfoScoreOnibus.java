package br.com.lcv.onibus;

import br.com.lcv.model.InfoBase;

public class InfoScoreOnibus {
	
	private InfoBase infoBase;
	private int score;
	
	public InfoScoreOnibus() {
		
	}
	
	public InfoScoreOnibus(InfoBase emailBase, int score) {
		this.infoBase = emailBase;
		this.score = score;
	}
	
	public InfoBase getInfoBase() {
		return infoBase;
	}

	public void setInfoBase(InfoBase infoBase) {
		this.infoBase = infoBase;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

}
