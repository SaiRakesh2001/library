package com.colruyt.assignmentapp.exception;
public class InvalidRequest extends RuntimeException{
    public InvalidRequest(String msg){
        super(msg);
    }
}