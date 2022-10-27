package dev.bigstack.springboot.model;

import lombok.Data;

@Data
public class Mark {
	private String id;
	private String name;
	private String description;
	private float mark; 
	
	public Mark(String id,
	String name,
	String description,
	float mark) {
		this.id = id;
		this.name=name;
		this.description =description;
		this.mark= mark;
	}
}