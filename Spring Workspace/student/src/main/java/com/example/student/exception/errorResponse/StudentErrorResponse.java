package com.example.student.exception.errorResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Setter
@Getter
public class StudentErrorResponse {
    private String message;
    private int statusCode;
    private HttpStatus status;

}
