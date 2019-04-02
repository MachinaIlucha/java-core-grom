package lesson15.DZ2;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] roomsGet = getAll();
        int i = 0;
        for (Room room : roomsGet) {
            if (room.getHotelName() == hotel && room.getCityName() == city && room.getPersons() == persons) {
                if (room.getPrice() == price || room.getPrice() > (room.getPrice() - 100) && room.getPrice() < (room.getPrice() + 100)) {
                    i++;
                }
            }
        }

        Room[] roomsFound = new Room[i];
        i = 0;

        for (Room room : roomsGet) {
            if (room.getHotelName() == hotel && room.getCityName() == city && room.getPersons() == persons) {
                if (room.getPrice() == price || room.getPrice() > (room.getPrice() - 100) && room.getPrice() < (room.getPrice() + 100)) {
                    roomsFound[i] = room;
                    i++;
                }
            }
        }

        return roomsFound;
    }

    @Override
    public Room[] getAll() {
        int i = 0;
        for (Room room : rooms) {
            if (room != null)
                i++;
        }

        Room[] allRooms = new Room[i];
        i = 0;

        for (Room room : rooms) {
            if (room != null) {
                allRooms[i] = room;
                i++;
            }
        }
        return allRooms;
    }
}
