package com.evergreen.university.student.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentServiceErrorHandler {

	@ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(StudentNotFoundException studentNotFoundException)
    {
		StudentErrorResponse error = new StudentErrorResponse(
				studentNotFoundException.getMessage(),
				studentNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
