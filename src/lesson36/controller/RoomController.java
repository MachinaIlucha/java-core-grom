package lesson36.controller;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.Session;
import lesson36.model.UserType;
import lesson36.service.RoomService;

import java.util.Collection;

public class RoomController {
    private RoomService roomService = new RoomService();

    public Collection findRooms(Filter filter) throws Exception {
        if (Session.getUser() != null)
            return roomService.findRooms(filter);
        else throw new BadRequestExeption("You are not logged in");
    }

    public Room addRoom(Room room) throws Exception {
       // if (Session.getUser() != null && Session.getUser().getUserType() != UserType.ADMIN)
            return roomService.addRoom(room);
//        else throw new BadRequestExeption("You are not logged in or you have no permission for this operation");
    }

    public void deleteRoom(long roomId) throws Exception {
       // if (Session.getUser() != null && Session.getUser().getUserType() != UserType.ADMIN)
            roomService.deleteRoom(roomId);
       // else throw new BadRequestExeption("You are not logged in or you have no permission for this operation");
    }
}
