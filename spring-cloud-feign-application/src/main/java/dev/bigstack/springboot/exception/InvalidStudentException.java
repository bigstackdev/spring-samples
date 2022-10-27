package dev.bigstack.springboot.exception;

import dev.bigstack.springboot.object.GlobalExceptionObject;

public class InvalidStudentException  extends GlobalExceptionObject {
	
    private static final long serialVersionUID = 1L;

	public InvalidStudentException(String message, String code) {
        super(message, code);
    }
	
}
