package lesson36.Demo;

import lesson36.controller.RoomController;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) throws Exception {
        RoomController controller = new RoomController();

        Hotel hotel = new Hotel(111111, "ukraine", "Kiev", "Obolon", "ObolonSk");

        Room room = new Room(654342, 1, 100.24, true, false, new Date(), hotel);

        controller.deleteRoom(654342);
//        controller.addRoom(room);
    }
}
