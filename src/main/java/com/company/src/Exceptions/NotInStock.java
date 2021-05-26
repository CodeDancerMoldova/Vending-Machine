package com.company.src.Exceptions;

public class NotInStock extends RuntimeException{
    private String message;

    public NotInStock(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
