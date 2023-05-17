package com.digdes.pcs.util.exception;


public class BLLException extends Exception{
    public BLLException(String message) {
        super(message);
    }

    public BLLException(String message, Throwable cause) {
        super(message, cause);
    }
}