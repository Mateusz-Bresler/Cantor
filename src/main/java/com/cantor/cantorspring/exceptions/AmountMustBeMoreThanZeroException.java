package com.cantor.cantorspring.exceptions;

public class AmountMustBeMoreThanZeroException extends RuntimeException{
    public AmountMustBeMoreThanZeroException(String message) {
        super(message);
    }
}
