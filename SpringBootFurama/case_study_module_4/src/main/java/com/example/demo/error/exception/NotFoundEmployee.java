package com.example.demo.error.exception;

public class NotFoundEmployee extends Exception {
    public NotFoundEmployee(String error) {
        super(error);
    }
}
