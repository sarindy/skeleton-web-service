package org.example.ws.model;

import java.math.BigInteger;

public class Greeting {
	private BigInteger id;
	
	private String text;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Greeting(BigInteger id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	
	
	

}
