package lesson36.service;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Hotel;
import lesson36.model.Session;
import lesson36.repository.HotelRepository;

import java.util.Collection;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

    public Collection findHotelByName(String name) throws BadRequestExeption {
        //TODO check business logic
        return hotelRepository.findHotelByCityOrName(name);
    }

    public Collection findHotelByCity(String city) throws BadRequestExeption {
        //TODO check business logic
        return hotelRepository.findHotelByCityOrName(city);
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        //TODO check business logic
        return hotelRepository.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        //TODO check business logic
        hotelRepository.deleteHotel(hotelId);
    }
}
