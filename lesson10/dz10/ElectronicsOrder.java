package lesson10.dz10;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    public void validateOrder() {
        String gender = getCustomerOwned().getGender();

        if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков") {
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков") {
                if (gender == "Женский" && getBasePrice() >= 100) {
                    setDateConfirmed(new Date());
                }
            }
        }
    }

    public void calculatePrice() {
        double elect = getBasePrice();
        double ship;
        if (getShipToCity() == "Киев" || getShipToCity() == "Одесса")
            ship = getBasePrice() * 0.10;
        else ship = getBasePrice() * 0.15;
        elect += ship;
        if (getBasePrice() > 1000)
            elect -= elect * 0.05;
        setTotalPrice(elect);
    }
}
