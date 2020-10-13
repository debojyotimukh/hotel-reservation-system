package com.capgemini.training.java.hotelreservation;

public class InvalidCustomerTypeException extends Throwable{

    /**
     *
     */
    private static final long serialVersionUID = -8209576211436962288L;

    public InvalidCustomerTypeException() {
    }

    public InvalidCustomerTypeException(String message) {
        super(message);
    }
    

}
