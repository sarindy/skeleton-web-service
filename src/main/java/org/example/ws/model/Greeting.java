package org.example.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {

	@Id
	@GeneratedValue
	private Long id;

	private String text;

	public Greeting() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long nextId) {
		this.id = nextId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
