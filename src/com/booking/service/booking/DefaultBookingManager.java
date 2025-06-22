package com.booking.service.booking;

import com.booking.customexceptions.BookingRequestNotFoundException;
import com.booking.customexceptions.InvalidBookingRequestException;
import com.booking.model.BookingRequest;
import com.booking.utils.AppStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultBookingManager implements BookingManager {
    Map<Integer, BookingRequest> bookings = new HashMap<>();
    private final AtomicInteger bookingIdCounter = new AtomicInteger(0);

    @Override
    public void createBooking(BookingRequest bookingRequest) {
        if (!bookingRequest.isValid()) {
            throw new InvalidBookingRequestException("Booking request is not valid");
        }
        int bookingId = bookingIdCounter.incrementAndGet();
        bookingRequest.setBookingId(bookingId);
        bookingRequest.setAppStatus(AppStatus.APPROVED);
        bookings.put(bookingId, bookingRequest);
    }

    @Override
    public void cancelBooking(int bookingId) {
        BookingRequest bookingRequest = bookings.get(bookingId);
        if (bookingRequest != null) {
            bookingRequest.setAppStatus(AppStatus.REJECTED);
        } else {
            throw new BookingRequestNotFoundException("Booking ID not found"); //
        }
    }

    @Override
    public AppStatus getBookingStatus(int bookingId) {
        BookingRequest bookingRequest = bookings.get(bookingId);
        if (bookingRequest != null) {
            return bookingRequest.getAppStatus();
        }
        throw new BookingRequestNotFoundException("Booking ID not found");
    }
}
