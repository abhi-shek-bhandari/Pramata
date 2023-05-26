package com.community.community.Exceptions;

public class MessageException extends RuntimeException{
    public MessageException() {
    }

    public MessageException(String message) {
        super(message);
    }
}
