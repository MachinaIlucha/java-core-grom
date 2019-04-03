package lesson36.repository;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomRepository extends GeneralRepository<Room> {

    public Collection findRooms(Filter filter) throws Exception {
        Set<Room> roomCollection = new TreeSet<>();
        for (Room room : createDb()) {
            Hotel hotel = room.getHotel();
            if (hotel.getCountry() == filter.getCountry() && hotel.getCity() == filter.getCity()) {
                if (room.getDateAvailableFrom() == filter.getDateAvailableFrom() && room.isPetsAllowed() == filter.isPetsAllowed()) {
                    if (room.isBreakfastIncluded() == filter.isBreakfastIncluded() && room.getPrice() == filter.getPrice() && room.getNumberOfGuests() == filter.getNumberOfGuests())
                        roomCollection.add(room);
                }
            }
        }
        return roomCollection;
    }

    public Room addRoom(Room room) throws Exception {
        checkRoomInDb(room);

        //TODO add to Db
        GeneralDAO.saveToDb(room, "C:\\Users\\Ilucha\\Desktop\\lastTask\\RoomDb.txt");
        return room;
    }

    public void deleteRoom(long roomId) throws Exception {
        String str = GeneralDAO.readFromFile("C:\\Users\\Ilucha\\Desktop\\lastTask\\RoomDb.txt").toString();
        if (!"".equals(str)) {
            //TODO remove from Db
            Set<Room> rooms = createDb();

            rooms.remove(findById(roomId));

            clearDb();
            for (Room room : rooms) {
                GeneralDAO.saveToDb(room, "C:\\Users\\Ilucha\\Desktop\\lastTask\\RoomDb.txt");
            }
        } else throw new BadRequestExeption("Sorry but no Room with id " + roomId + " in Db");
    }


    /******************************************************************************************************************/


    private void checkRoomInDb(Room room) throws Exception {
        for (Room room1 : createDb()) {
            if (room1.getId() == room.getId())
                throw new BadRequestExeption("This room " + room.getId() + " already in Db");
        }
    }

    public static Room findById(long roomId) throws Exception {
        for (Room room : createDb()) {
            if (room != null && roomId == room.getId())
                return room;
        }
        throw new BadRequestExeption("Room with id: " + roomId + " not found");
    }

    private static Set<Room> createDb() throws Exception {
        RoomRepository roomRepository = new RoomRepository();
        return GeneralDAO.mapping("C:\\Users\\Ilucha\\Desktop\\lastTask\\RoomDb.txt", roomRepository);
    }

    private void clearDb() {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Ilucha\\Desktop\\lastTask\\RoomDb.txt")) {
            writer.print("");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    @Override
    public Room mapObject(String[] data) throws Exception {
            if (data.length > 5) {
                Hotel hotel = HotelRepository.findById(Long.parseLong(data[6].trim()));

                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                Date date = format.parse(data[5].trim());

                Room room = new Room(Long.parseLong(data[0].trim()), Integer.parseInt(data[1].trim()), Double.parseDouble(data[2].trim()), Boolean.parseBoolean(data[3].trim()),
                        Boolean.parseBoolean(data[4].trim()), date, hotel);
                return room;
            } else throw new BadRequestExeption("Sorry but not enough data in db");
    }
}
