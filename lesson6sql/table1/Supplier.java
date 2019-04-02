package lesson6.table1;

public class Supplier {
    private int SupplierID;
    private String CompanyName;
    private String ContactName;
    private String ContactTitle;
    private String Address;
    private String City;
    private String Region;
    private int PostalCode;
    private String Country;
    private int Phone;
    private int Fax;
    private String HomePage;

    public Supplier(int supplierID, String companyName, String contactName, String contactTitle, String address, String city, String region, int postalCode, String country, int phone, int fax, String homePage) {
        SupplierID = supplierID;
        CompanyName = companyName;
        ContactName = contactName;
        ContactTitle = contactTitle;
        Address = address;
        City = city;
        Region = region;
        PostalCode = postalCode;
        Country = country;
        Phone = phone;
        Fax = fax;
        HomePage = homePage;
    }
}
