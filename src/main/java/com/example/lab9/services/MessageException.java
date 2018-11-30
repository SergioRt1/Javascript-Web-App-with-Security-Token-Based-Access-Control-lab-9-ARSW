package com.example.lab9.services;

public class MessageException extends Exception{

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(String message) {
        super(message);
    }

}
