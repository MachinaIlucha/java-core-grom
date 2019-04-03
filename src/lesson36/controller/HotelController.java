package lesson36.controller;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Hotel;
import lesson36.model.Session;
import lesson36.model.UserType;
import lesson36.service.HotelService;

import java.util.Collection;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public Collection findHotelByName(String name) throws BadRequestExeption {
        if (Session.getUser() != null)
            return hotelService.findHotelByName(name);
        else throw new BadRequestExeption("You are not logged in");
    }

    public Collection findHotelByCity(String city) throws BadRequestExeption {
        if (Session.getUser() != null)
            return hotelService.findHotelByCity(city);
        else throw new BadRequestExeption("You are not logged in");
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
     //   if (Session.getUser() != null && Session.getUser().getUserType() != UserType.ADMIN)
            return hotelService.addHotel(hotel);
//        else throw new BadRequestExeption("You are not logged in or you have no permission for this operation");
    }

    public void deleteHotel(long hotelId) throws Exception {
      //  if (Session.getUser() != null && Session.getUser().getUserType() != UserType.ADMIN)
            hotelService.deleteHotel(hotelId);
//        else throw new BadRequestExeption("You are not logged in or you have no permission for this operation");
    }

}
