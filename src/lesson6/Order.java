package lesson6;

import java.util.Date;

public class Order {

    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;


    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public Order() {
    }

    void confirmOrder() {
        if (isConfirmed != true) {
            this.isConfirmed = true;
            this.dateConfirmed = new Date();
        }
    }

    boolean checkPrice() {
        boolean p;
        if (this.price > 1000)
            p = true;
        else p = false;
        return p;
    }

    boolean isValidType() {
        boolean p;
        if (this.type == "Buy" || this.type == "Sale")
            p = true;
        else p = false;

        return p;
    }
}
