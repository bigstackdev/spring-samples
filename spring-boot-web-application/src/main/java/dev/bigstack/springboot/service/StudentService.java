package dev.bigstack.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.bigstack.springboot.model.Mark;
import dev.bigstack.springboot.model.Student;

@Service
public interface StudentService{
    Student retrieveStudent(int studentId);
    List<Student> retrieveAllStudent();
    List<Mark> retrieveCourses(int studentId);
}