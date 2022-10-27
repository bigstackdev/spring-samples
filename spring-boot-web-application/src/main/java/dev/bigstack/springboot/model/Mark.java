package dev.bigstack.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "MARK")
public class Mark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int studentId;
	private String name;
	private String description;
	private float mark; 
	
	public Mark(int id, int studentId,
	String name,
	String description,
	float mark) {
		this.id = id;
		this.studentId = studentId;
		this.name=name;
		this.description =description;
		this.mark= mark;
	}
}