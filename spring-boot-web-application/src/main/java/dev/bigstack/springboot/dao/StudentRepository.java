package dev.bigstack.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.bigstack.springboot.model.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {

}
