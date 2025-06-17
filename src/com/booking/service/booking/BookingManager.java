package com.booking.service.booking;

import com.booking.model.BookingRequest;
import com.booking.utils.AppStatus;

public interface BookingManager {

    void createBooking(BookingRequest bookingRequest);

    void cancelBooking(int bookingId);

    AppStatus getBookingStatus(int bookingId);
}
