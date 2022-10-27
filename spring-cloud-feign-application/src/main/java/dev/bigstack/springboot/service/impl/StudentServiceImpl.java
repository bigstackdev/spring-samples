package dev.bigstack.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import dev.bigstack.springboot.constants.ErrorCodes;
import dev.bigstack.springboot.exception.InvalidStudentException;
import dev.bigstack.springboot.model.Mark;
import dev.bigstack.springboot.model.Student;
import dev.bigstack.springboot.rest.StudentRestService;
import dev.bigstack.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private static final List<Student> students = new ArrayList<>();

    static {
        // Initialize Data
        Mark mark1 = new Mark("Course1", "Spring", "out of 100",90f);
        Mark mark2 = new Mark("Course2", "Java", "out of 100",97f);
        Mark mark3 = new Mark("Course3", "HTML", "out of 100",99f);
        
        Student stud1 = new Student("Student001", "Big Stack",
                "Programmer and Architect", new ArrayList<>(List.of(mark1, mark2, mark3)));

        students.add(stud1);
    }

    public Student retrieveStudent(String studentId) throws Exception {
        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findAny()
                .orElseThrow(Exception::new);
    }

    public List<Mark> retrieveCourses(String studentId) {
        Student student = null;
		try {
			student = retrieveStudent(studentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InvalidStudentException("We couldn't find student under given identification. Please check and retry", ErrorCodes.ERROR_ENTITY_NOT_FOUND);

		}

        return student == null ? null : student.getMarks();

    }
}