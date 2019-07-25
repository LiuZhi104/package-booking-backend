package com.oocl.packagebooking.exception;

public class ErrorBookingTimeException extends RuntimeException {
    public ErrorBookingTimeException() {
    }

    public ErrorBookingTimeException(String message) {
        super(message);
    }
}
