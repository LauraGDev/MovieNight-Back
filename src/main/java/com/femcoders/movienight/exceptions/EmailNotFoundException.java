package com.femcoders.movienight.exceptions;

public class EmailNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public EmailNotFoundException(String message) {
        super(message);
    }

}
