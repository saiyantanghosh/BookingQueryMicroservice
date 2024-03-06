package com.abc.bookstore.exception;

public class BusinessException extends Exception{
    private final String  code;

    public BusinessException(String code, String message,Throwable cause){
        super(message,cause);
        this.code = code;
    }
    public BusinessException(String code, String message){
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
