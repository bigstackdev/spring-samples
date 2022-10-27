package dev.bigstack.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.bigstack.springboot.constants.ErrorCodes;
import dev.bigstack.springboot.dao.MarkRepository;
import dev.bigstack.springboot.dao.StudentRepository;
import dev.bigstack.springboot.exception.InvalidStudentException;
import dev.bigstack.springboot.model.Mark;
import dev.bigstack.springboot.model.Student;
import dev.bigstack.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
    private MarkRepository markRepository;
	
    private static final List<Student> students = new ArrayList<>();

    static {
        // Initialize Data
        Mark mark1 = new Mark(1, 1, "Spring", "out of 100",90f);
        Mark mark2 = new Mark(2, 1, "Java", "out of 100",97f);
        Mark mark3 = new Mark(3, 1, "HTML", "out of 100",99f);
       
        Student stud1 = new Student(0, "Big Stack",
                "Programmer and Architect", new ArrayList<>(List.of(mark1, mark2, mark3)));

        students.add(stud1);
    } 
    
    

    public Student retrieveStudent(int studentId) {
    	 log.info("student save : before ");
    	 Student stud1 = new Student(0, "Big Stack", "Programmer and Architect", null);
    	studentRepository.save((stud1));
    	 log.info("student save : after ");
    
        try {
			return students.stream()
			        .filter(student -> student.getId()==studentId)
			        .findAny()
			        .orElseThrow(Exception::new);
		} catch (Exception e) {
			 Mark mark2 = new Mark(0, 1, "Java", "out of 100",97f);
			 log.info("student save : before ");
			 markRepository.save(mark2);
			 log.info("student save : after ");
			throw new InvalidStudentException("We couldn't find student under given identification. Please check and retry", ErrorCodes.ERROR_ENTITY_NOT_FOUND);
		}
    }

    public List<Mark> retrieveCourses(int studentId) {
        Student student = null;
		try {
			student = retrieveStudent(studentId);
		} catch (Exception e) {
	        Mark mark1 = new Mark(0, 1, "Spring", "out of 100",90f);
	        markRepository.save(mark1);
			// TODO Auto-generated catch block
			throw new InvalidStudentException("We couldn't find student under given identification. Please check and retry", ErrorCodes.ERROR_ENTITY_NOT_FOUND);

		}

        return student == null ? null : student.getMarks();

    }

	@Override
	public List<Student> retrieveAllStudent() {
		
	   	 log.info("student select  ");
	   	 List<Mark> mL = markRepository.findAll();
	   	 List<Student> sL = studentRepository.findAll();
	   	List<Student> rstudents = new ArrayList<>();
	   	 sL.forEach(s -> { s.setMarks(mL); rstudents.add(s); });
   
		return rstudents;
	}
}