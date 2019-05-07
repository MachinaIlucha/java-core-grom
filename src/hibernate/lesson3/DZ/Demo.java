package hibernate.lesson3.DZ;

public class Demo {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.setCITY("Kiev");
        hotel.setCOUNTRY("Ukraine");
        hotel.setNAMEOFHOTEL("Dominic444");
        hotel.setSTREET("Obolon");

        HotelDAO.save(hotel);
    }
}
