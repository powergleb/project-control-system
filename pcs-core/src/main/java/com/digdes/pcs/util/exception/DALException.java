package com.digdes.pcs.util.exception;



public class DALException extends Exception{
    public DALException(String message) {
        super(message);
    }

    public DALException(String message, Exception cause) {
        super(message, cause);
    }
}