package lesson10.dz10;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("Кирил", "Киев", "Мужской");

        ElectronicsOrder eOrder = new ElectronicsOrder("Холодильник", new Date(), "Киев", "Одесса", 4876, customer, 12);
        ElectronicsOrder eOrder2 = new ElectronicsOrder("Чайник", new Date(), "Киев", "Львов", 800, customer, 3);

        FurnitureOrder fOrder = new FurnitureOrder("Ручка", new Date(), "Киев", "Харьков", 250, customer, "12432");
        FurnitureOrder fOrder2 = new FurnitureOrder("Гвоздь", new Date(), "Киев", "Винница", 24, customer, "13532");

        eOrder.validateOrder();
        eOrder.calculatePrice();

        eOrder2.validateOrder();
        eOrder2.calculatePrice();

        fOrder.validateOrder();
        fOrder.calculatePrice();

        fOrder2.validateOrder();
        fOrder2.calculatePrice();
    }
}
