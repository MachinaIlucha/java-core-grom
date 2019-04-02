package lesson6.table1;

import java.util.Date;

public class Orders {
    private int OrderID;
    private Customers customer;
    private Employees employee;
    private Date OrderDate;
    private Date RequiredDate;
    private Date ShippedDate;
    private String ShipVia;
    private String Freight;
    private Shippers shipper;
    private String ShipAdress;
    private String ShipCity;
    private String ShipRegion;
    private String ShipPostalCode;
    private String ShipCountry;

    public Orders(int orderID, Customers customer, Employees employee, Date orderDate, Date requiredDate, Date shippedDate, String shipVia, String freight, Shippers shipper, String shipAdress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
        OrderID = orderID;
        this.customer = customer;
        this.employee = employee;
        OrderDate = orderDate;
        RequiredDate = requiredDate;
        ShippedDate = shippedDate;
        ShipVia = shipVia;
        Freight = freight;
        this.shipper = shipper;
        ShipAdress = shipAdress;
        ShipCity = shipCity;
        ShipRegion = shipRegion;
        ShipPostalCode = shipPostalCode;
        ShipCountry = shipCountry;
    }
}
