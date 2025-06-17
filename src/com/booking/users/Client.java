package com.booking.users;

import com.booking.model.BookingRequest;
import com.booking.service.booking.DefaultBookingManager;
import com.booking.utils.AppStatus;

public class Client{
    int id;
    String name;
    int phoneNumber;

    public Client(int id, String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public void requestBooking(DefaultBookingManager bookingManager, BookingRequest bookingRequest) {
        bookingManager.createBooking(bookingRequest);
        System.out.println("Запрос на бронирование отправлен:" + " \nИмя:" + this.name + " \nНомер телефона: " + this.phoneNumber);
    }

    public void checkBookingStatus(DefaultBookingManager bookingManager, int bookingId) {
        AppStatus bookingStatus = bookingManager.getBookingStatus(bookingId);
        System.out.println("ID бронирования: " + bookingId + " статус: " + bookingStatus);
    }
}
