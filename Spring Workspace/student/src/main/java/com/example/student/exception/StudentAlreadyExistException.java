package com.example.student.exception;

import jakarta.persistence.EntityNotFoundException;

import java.rmi.AlreadyBoundException;

public class StudentAlreadyExistException extends EntityNotFoundException {

    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
