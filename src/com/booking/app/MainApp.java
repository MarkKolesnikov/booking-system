package com.booking.app;

import com.booking.model.BookingRequest;
import com.booking.model.Room;
import com.booking.service.booking.DefaultBookingManager;
import com.booking.users.Admin;
import com.booking.users.Client;

public class MainApp {

    public static void main(String[] args) {
        DefaultBookingManager bookingManager = new DefaultBookingManager();
        Admin admin = new Admin(bookingManager);

        Client client = new Client(1, "Mark Kolesnikov", 960453272);
        BookingRequest request = new BookingRequest(new Room(1), client);
        client.requestBooking(bookingManager, request);
        client.checkBookingStatus(bookingManager, 1);
        admin.cancelBooking(1);
        client.checkBookingStatus(bookingManager, 1);

        Client client2 = new Client(2, "Elizaveta Koshelec", 960458737);
        BookingRequest request2 = new BookingRequest(new Room(2), client2);
        client2.requestBooking(bookingManager, request2);
        client2.checkBookingStatus(bookingManager, 2);
        admin.cancelBooking(2);
        client2.checkBookingStatus(bookingManager, 2);
    }
}