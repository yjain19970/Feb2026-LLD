package com.example.scaler.bms.may2026.exception;

public class SeatNotAvailableException extends Exception {

    public SeatNotAvailableException() {
    }

    public SeatNotAvailableException(String message) {
        super(message);
    }

    public SeatNotAvailableException(Throwable cause) {
        super(cause);
    }

    public SeatNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatNotAvailableException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
