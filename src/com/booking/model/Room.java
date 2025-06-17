package com.booking.model;

public class Room {
    private int id;
    private boolean isOccupied;

    public Room(Integer id) {
        this.id = id;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOccupied() {
        return false;
    }

    public int getId() {
        return id;
    }
}
