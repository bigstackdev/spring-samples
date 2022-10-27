package dev.bigstack.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.bigstack.springboot.model.Mark;
import dev.bigstack.springboot.model.Student;

@Service
public interface StudentService {
    Student retrieveStudent(String studentId) throws Exception;
    List<Mark> retrieveCourses(String studentId);
}