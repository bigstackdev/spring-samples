package dev.bigstack.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "STUDENT")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String description;
	
	@Transient
	private List<Mark> marks; 
    
    public Student(int id,
    String name,
    String description,
    List<Mark> marks) {
    	this.id=id;
		this.name=name;
		this.description =description;
		this.marks= marks;
    }

}
