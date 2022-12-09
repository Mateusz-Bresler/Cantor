package com.cantor.cantorspring.exceptions;

public class CanNotReturnStringFromUrlException extends RuntimeException{
    public CanNotReturnStringFromUrlException(String message) {
        super(message);
    }
}
