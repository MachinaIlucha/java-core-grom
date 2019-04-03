package lesson36.Demo;

import lesson36.controller.HotelController;
import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

public class HotelDemo {
    public static void main(String[] args) throws Exception {
        HotelController controller = new HotelController();

        Hotel hotel = new Hotel(34567756, "Norway", "Oslo", "ter768n", "Norway222223");
        Hotel hotel2 = new Hotel(44444444, "gfhd", "hsrt", "te534zen", "NorwayV77776");
        Hotel hotel3 = new Hotel(655555555, "55555", "Oslo", "tehdszen", "222222222");
        Hotel hotel4 = new Hotel(377777777, "qqqq", "Ogerto", "trtyhn", "Norwayurtyurt");

//        controller.addHotel(hotel);
//        controller.addHotel(hotel2);
//        controller.addHotel(hotel3);
//        controller.addHotel(hotel4);
      controller.deleteHotel(655555555);
    }
}
