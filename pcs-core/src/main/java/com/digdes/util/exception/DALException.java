package com.digdes.util.exception;



public class DALException extends Exception{
    public DALException(String message) {
        super(message);
    }

    public DALException(String message, Exception cause) {
        super(message, cause);
    }
}