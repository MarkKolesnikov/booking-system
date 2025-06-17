package com.booking.users;

import com.booking.model.BookingRequest;
import com.booking.service.booking.DefaultBookingManager;
import com.booking.utils.AppStatus;

public class Admin {
    private final DefaultBookingManager bookingManager;

    public Admin(DefaultBookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void addBooking(BookingRequest bookingRequest) {
        bookingManager.createBooking(bookingRequest);
        System.out.println("Обращение добавлено");
    }

    public void cancelBooking(Integer bookingId) {
        bookingManager.cancelBooking(bookingId);
        System.out.println("Обращение отменено");
    }

    public void checkBookingStatus(int bookingId) {
        AppStatus bookingStatus = bookingManager.getBookingStatus(bookingId);
        System.out.println("Статус обращения: " + bookingStatus);
    }
}
