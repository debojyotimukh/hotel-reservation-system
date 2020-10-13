package com.capgemini.training.java.hotelreservation;

public class InvalidDateException extends Throwable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    InvalidDateException(String message) {
        super(message);
    }

}
