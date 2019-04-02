package lesson36.model;

public class Hotel {
    private long id;
    private String country;
    private String city;
    private String street;
    private String name;

    public Hotel(long id, String country, String city, String street, String name) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" +
                "" + id +
                ", " + country +
                ", " + city +
                ", " + street +
                ", " + name;
    }
}
