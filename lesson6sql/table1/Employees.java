package lesson6.table1;

import java.util.Date;

public class Employees {
    private int EmployeeID;
    private String LastName;
    private String FirstName;
    private String Title;
    private String TitleOfCourtesy;
    private Date BirthDate;
    private Date HireDate;
    private String Address;
    private String City;
    private String Region;
    private int PostalCode;
    private String Country;
    private String HomePhone;
    private String Extension;
    private String Photo;
    private String Notes;
    private String ReportsTo;

    public Employees(int employeeID, String lastName, String firstName, String title, String titleOfCourtesy, Date birthDate, Date hireDate, String address, String city, String region, int postalCode, String country, String homePhone, String extension, String photo, String notes, String reportsTo) {
        EmployeeID = employeeID;
        LastName = lastName;
        FirstName = firstName;
        Title = title;
        TitleOfCourtesy = titleOfCourtesy;
        BirthDate = birthDate;
        HireDate = hireDate;
        Address = address;
        City = city;
        Region = region;
        PostalCode = postalCode;
        Country = country;
        HomePhone = homePhone;
        Extension = extension;
        Photo = photo;
        Notes = notes;
        ReportsTo = reportsTo;
    }
}
