package dev.bigstack.springboot.model;

import java.util.List;

import lombok.Data;


@Data
public class Student {
	private String id;
	private String name;
	private String description;
	private List<Mark> marks; 
    
    public Student(String id,
    String name,
    String description,
    List<Mark> marks) {
    	this.id=id;
		this.name=name;
		this.description =description;
		this.marks= marks;
    }

}