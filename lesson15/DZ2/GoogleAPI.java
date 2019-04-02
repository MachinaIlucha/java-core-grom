package lesson15.DZ2;

import java.util.Arrays;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoogleAPI googleAPI = (GoogleAPI) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(rooms, googleAPI.rooms);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rooms);
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] roomsGet = getAll();
        int i = 0;
        for (Room room : roomsGet) {
            if (room.getHotelName() == hotel && room.getCityName() == city && room.getPrice() == price && room.getPersons() == persons) {
                i++;
            }
        }

        Room[] roomsFound = new Room[i];
        i = 0;

        for (Room room : roomsGet) {
            if (room.getHotelName() == hotel && room.getCityName() == city && room.getPrice() == price && room.getPersons() == persons) {
                roomsFound[i] = room;
                i++;
            }
        }
        return roomsFound;
    }

    @Override
    public Room[] getAll() {
        int i = 0;
        for (Room room : rooms) {
            if (!room.equals(null))
                i++;
        }

        Room[] allRooms = new Room[i];
        i = 0;

        for (Room room : rooms) {
            if (!room.equals(null)) {
                allRooms[i] = room;
                i++;
            }
        }
        return allRooms;
    }
}
