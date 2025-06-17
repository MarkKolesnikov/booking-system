package com.booking.service.room;

import com.booking.customexceptions.RoomNotFoundException;
import com.booking.model.Room;
import com.booking.utils.AppStatus;

import java.util.HashMap;
import java.util.Map;

public class DefaultRoomManager implements RoomManager {
    private final Map<Integer, Room> rooms = new HashMap<>();
    private int nextId = 1;

    @Override
    public void addRoom(Room room) {
        Room joinRoom = new Room(nextId++);
        rooms.put(nextId, joinRoom);
    }

    @Override
    public void removeRoom(Integer id) {
        if (id != null && rooms.containsKey(id)) {
            rooms.remove(id);
        } else {
            throw new RoomNotFoundException("Такой комнаты не существует");
        }
    }

    @Override
    public boolean roomExistence(int roomId) {
        return rooms.containsKey(roomId);
    }

    @Override
    public void listAllRooms() {
        for (Room room : rooms.values()) {
            System.out.println(room.toString());
        }
    }

    @Override
    public Room getRoomById(int roomId) {
        return rooms.get(roomId);
    }

    @Override
    public void getRoomsByStatus(AppStatus status) {
        for (Room room : rooms.values()) {
            boolean isRoomStatusMatch = (status == AppStatus.APPROVED && room.isOccupied())
                    || (status == AppStatus.REJECTED && !room.isOccupied());

            if (isRoomStatusMatch) {
                System.out.println("ID комнаты: " + room.getId() + " Статус: " + (room.isOccupied() ? "Занятый" : "Доступный"));
            }
        }
    }
}
