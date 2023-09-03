package com.juba13.dyboard.exception;

public class AppEx extends RuntimeException {
    private String message;
    private Throwable throwable;
    
    private AppEx(Throwable throwable) {
        super(throwable);
        this.throwable=throwable;
    }

    private AppEx(String message) {
        super(message);
        this.message=message;
    }

    private AppEx(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.throwable=throwable;
    }

    public static AppEx create(Throwable throwable) {
        return new AppEx(throwable);
    }

    public static AppEx create(String message) {
        return new AppEx(message);
    }

    public static AppEx create(String message, Throwable throwable) {
        return new AppEx(message, throwable);
    }

    public String getMessgae() {
        return this.message;
    }
    public Throwable getThrowable() {
        return this.throwable;
    }
}
