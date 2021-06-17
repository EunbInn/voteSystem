package kr.ac.kopo.kopo08.domain;

public class Hubo {
	private int kiho;
	private String name;
	private int voteCnt;
	private double votePer;

	public Hubo() {

	}
	
	public Hubo(int kiho,String name) {
		this.kiho = kiho;
		this.name = name;
		this.voteCnt = 0;
		this.votePer = 0.0;
	}
	
	public int getKiho() {
		return kiho;
	}

	public void setKiho(int kiho) {
		this.kiho = kiho;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVoteCnt() {
		return voteCnt;
	}

	public void setVoteCnt(int voteCnt) {
		this.voteCnt = voteCnt;
	}

	public double getVotePer() {
		return votePer;
	}

	public void setVotePer(double votePer) {
		this.votePer = votePer;
	}
	
	

}
