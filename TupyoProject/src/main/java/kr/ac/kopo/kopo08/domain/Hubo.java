package kr.ac.kopo.kopo08.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hubo {
	private int kiho;
	private String name;

	public Hubo() {

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

}
