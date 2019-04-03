package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.repository.RoomRepository;

import java.util.Collection;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public Collection findRooms(Filter filter) throws Exception {
        return roomRepository.findRooms(filter);
    }

    public Room addRoom(Room room) throws Exception {
        return roomRepository.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        roomRepository.deleteRoom(roomId);
    }
}
