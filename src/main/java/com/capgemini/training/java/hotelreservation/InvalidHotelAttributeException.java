package com.capgemini.training.java.hotelreservation;

public class InvalidHotelAttributeException extends Throwable {

    /**
     *
     */
    private static final long serialVersionUID = 8052117378428866972L;

    public InvalidHotelAttributeException() {
    }

    public InvalidHotelAttributeException(String message) {
        super(message);
    }

}
