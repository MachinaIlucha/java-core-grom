package lesson36.model;

import java.util.List;

public class User {
    private long id;
    private String userName;
    private String country;
    private String password;
    private List<Room> roomsReserved;
    private UserType userType;

    public User(long id, String userName, String country, String password, List<Room> roomsReserved, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.country = country;
        this.password = password;
        this.roomsReserved = roomsReserved;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getCountry() {
        return country;
    }

    public List<Room> getRoomsReserved() {
        return roomsReserved;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" +
                "" + id +
                ", " + userName +
                ", " + country +
                ", " + password +
                ", " + roomsReserved +
                ", " + userType;
    }
}
