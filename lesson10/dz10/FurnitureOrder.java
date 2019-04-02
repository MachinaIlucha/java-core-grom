package lesson10.dz10;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    public void validateOrder() {
        String name = getCustomerOwned().getName();
        if (getShipFromCity() == "Киев" || getShipFromCity() == "Львов") {
            if (getBasePrice() >= 500 && name != "Тест") {
                setDateConfirmed(new Date());
            }
        }
    }

    public void calculatePrice() {
        double elec = getBasePrice();
        double ship;
        if (getBasePrice() < 5000)
            elec += elec * 0.05;
        else elec += elec * 0.02;
        setTotalPrice(elec);
    }
}
