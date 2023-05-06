package com.evergreen.university.student.error;

public class StudentNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -8334090361905043174L;

	public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
