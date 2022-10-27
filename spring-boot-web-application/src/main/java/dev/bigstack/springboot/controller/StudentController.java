package dev.bigstack.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.bigstack.springboot.constants.ErrorCodes;
import dev.bigstack.springboot.object.ResponseObject;
import dev.bigstack.springboot.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<?> retrieveAllStudent() {
        return new ResponseEntity<ResponseObject>(ResponseObject.builder().code(ErrorCodes.SUCCESS).message(ErrorCodes.SUCCESS_MSG).data(studentService.retrieveAllStudent()).build(),  HttpStatus.OK);
    }
    
    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> retrieveForStudent(@PathVariable int studentId) {
        return new ResponseEntity<ResponseObject>(ResponseObject.builder().code(ErrorCodes.SUCCESS).message(ErrorCodes.SUCCESS_MSG).data(studentService.retrieveStudent(studentId)).build(),  HttpStatus.OK);
    }
    
    @GetMapping("/students/{studentId}/marks")
    public ResponseEntity<?> retrieveMarksForStudent(@PathVariable int studentId) {
        return new ResponseEntity<ResponseObject>(ResponseObject.builder().code(ErrorCodes.SUCCESS).message(ErrorCodes.SUCCESS_MSG).data(studentService.retrieveCourses(studentId)).build(),  HttpStatus.OK);
    }
}
