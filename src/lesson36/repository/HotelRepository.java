package lesson36.repository;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Hotel;

import java.io.*;
import java.util.*;

public class HotelRepository<T> extends GeneralRepository<Hotel> {

    public Collection findHotelByCityOrName(T t) throws BadRequestExeption {
        StringBuffer stringBuffer = GeneralDAO.readFromFile("C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt");
        String text = stringBuffer.toString();

        String[] lines = text.split("\n");

        Set<Hotel> hotelsByCity = new HashSet<>();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.contains(t.toString())) {
                String[] data = line.split(",");
                if (data.length > 4) {
                    Hotel hotel = new Hotel(Long.parseLong(data[0]), data[1], data[2], data[3], data[4]);
                    hotelsByCity.add(hotel);
                } else throw new BadRequestExeption("Sorry but not enough data in db");
            }
        }

        if (hotelsByCity.isEmpty())
            throw new BadRequestExeption("Sorry but " + t.toString() + " does not exist");
        else return hotelsByCity;
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        String str = GeneralDAO.readFromFile("C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt").toString();
        if (!"".equals(str))
            checkHotelInDb(hotel);

        //TODO add to Db
        GeneralDAO.saveToDb(hotel, "C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt");
        return hotel;
    }

    public void deleteHotel(long hotelId) throws Exception {
        //TODO remove from Db
        String str = GeneralDAO.readFromFile("C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt").toString();
        if (!"".equals(str)) {
            Set<Hotel> hotels = createDb();
            hotels.remove(findById(hotelId));
            clearDb();
            for (Hotel hotel1 : hotels) {
                GeneralDAO.saveToDb(hotel1, "C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt");
            }
        } else throw new BadRequestExeption("Sorry but no Hotel with id " + hotelId + " in Db");
    }


    /******************************************************************************************************************/


    private void checkHotelInDb(Hotel hotel) throws Exception {
        Set<Hotel> hotels = createDb();
        for (Hotel hotel1 : hotels) {
            if (hotel1.getId() == hotel.getId())
                throw new BadRequestExeption("This hotel " + hotel.getId() + " already in Db");
        }
    }

    public static Hotel findById(long hotelId) throws Exception {
        for (Hotel hotel : createDb()) {
            if (hotel != null && hotelId == hotel.getId())
                return hotel;
        }
        throw new BadRequestExeption("Hotel with id: " + hotelId + " not found");
    }

    public static Set<Hotel> createDb() throws Exception {
        HotelRepository hotelRepository = new HotelRepository();
        return GeneralDAO.mapping("C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt", hotelRepository);
    }

    private void clearDb() {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Ilucha\\Desktop\\lastTask\\HotelDb.txt")) {
            writer.print("");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    @Override
    public Hotel mapObject(String[] data) throws Exception {
        if (data.length > 4) {
            Hotel hotel = new Hotel(Long.parseLong(data[0]), data[1], data[2], data[3], data[4]);
            return hotel;
        } else throw new BadRequestExeption("Sorry but not enough data in db");
    }
}
