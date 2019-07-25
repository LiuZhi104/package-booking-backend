package com.oocl.packagebooking.exception;

public class NoSuchPackageException extends RuntimeException {
    public NoSuchPackageException() {
    }

    public NoSuchPackageException(String message) {
        super(message);
    }
}
