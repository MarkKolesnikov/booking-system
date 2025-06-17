package com.booking.service.room;

import com.booking.model.Room;
import com.booking.utils.AppStatus;

public interface RoomManager {

    void addRoom(Room room);

    void removeRoom(Integer id);

    boolean roomExistence(int roomId);

    // Выдача списка комнат по статусу (свободные/занятые).
    void listAllRooms();

    Room getRoomById(int roomId);

    //выводи комнаты с определённым статусом
    void getRoomsByStatus(AppStatus status);
}
