package com.example.demo.error.handleException;

public class NotFoundEntityById extends Exception {
    public NotFoundEntityById(String str){
        super(str);
    }
}
