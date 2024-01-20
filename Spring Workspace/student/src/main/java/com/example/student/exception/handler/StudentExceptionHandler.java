package com.example.student.exception.handler;

import com.example.student.exception.StudentAlreadyExistException;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.exception.errorResponse.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND);
        studentErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentAlreadyExistException(StudentAlreadyExistException studentAlreadyExistException) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setMessage(studentAlreadyExistException.getMessage());
        studentErrorResponse.setStatus(HttpStatus.CONFLICT);
        studentErrorResponse.setStatusCode(HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.CONFLICT);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleOtherStudentException(Exception e) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST);
        studentErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
