package com.cantor.cantorspring.exceptions;

public class CurrencyDoesNotExistException  extends RuntimeException{
    public CurrencyDoesNotExistException(String message) {
        super(message);
    }
}
