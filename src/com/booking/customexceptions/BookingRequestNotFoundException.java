package com.booking.customexceptions;

public class BookingRequestNotFoundException extends RuntimeException {
    public BookingRequestNotFoundException(String message) {
        super(message);
    }
}
