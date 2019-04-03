CREATE TABLE Suppliers(
    SupplierID NUMBER ,
    CONSTRAINT Supplier_PK PRIMARY KEY (SupplierID),
    CompanyName NVARCHAR2(50) UNIQUE NOT NULL,
    ContactName NVARCHAR2(20),
    ContactTitle NVARCHAR2(20),
    Address NVARCHAR2(50),
    City NVARCHAR2(20),
    Region NVARCHAR2(20),
    PostalCode NUMBER,
    Country NVARCHAR2(20),
    Phone NUMBER,
    Fax NUMBER,
    HomePage NVARCHAR2(50)
);

CREATE TABLE Products(
    ProductID NUMBER ,
    CONSTRAINT Product_PK PRIMARY KEY (ProductID),
    ProductName NVARCHAR2(50) NOT NULL,
    SupplierID NUMBER ,
    CONSTRAINT Supplier_FK FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    CategoryID NUMBER ,
    CONSTRAINT Category_FK FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
    QuantilyPerUnit NUMBER,
    UnitPrice NUMBER,
    UnitsInStock NUMBER,
    UnitsOnOrder NUMBER,
    ReorderLevel NUMBER,
    Discontinued NUMBER
);

CREATE TABLE Categories(
    CategoryID NUMBER ,
    CONSTRAINT Category_PK PRIMARY KEY (CategoryID),
    CategoryName NVARCHAR2(20) UNIQUE NOT NULL,
    Description CLOB,
    Picture NVARCHAR2(100)
);

CREATE TABLE OrderDetails(
    OrderID NUMBER ,
    CONSTRAINT Order_FK FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    ProductID NUMBER ,
    CONSTRAINT Product_FK FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    UnitPrice NUMBER ,
    CONSTRAINT UnitPrice_FK FOREIGN KEY (UnitPrice) REFERENCES Products(UnitPrice),
    Quantily NUMBER ,
    CONSTRAINT Quantily_FK FOREIGN KEY (Quantily) REFERENCES Products(QuantilyPerUnit)
);

CREATE TABLE Orders(
    OrderID NUMBER ,
    CONSTRAINT Order_PK PRIMARY KEY (OrderID),
    CustomerID NUMBER,
    CONSTRAINT OrderCustomer_FK FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    EmployeeID NUMBER,
    CONSTRAINT OrderEmployee_FK FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    OrderDate TIMESTAMP,
    RequiredDate TIMESTAMP,
    ShippedDate TIMESTAMP,
    ShipVia NVARCHAR2(50),
    Freight NVARCHAR2(50),
    ShipName NVARCHAR2(50),
    CONSTRAINT OrderShipper_FK FOREIGN KEY (ShipName) REFERENCES Shippers(CompanyName),
    ShipAdress NVARCHAR2(50),
    ShipCity NVARCHAR2(20),
    ShipRegion NVARCHAR2(20),
    ShipPostalCode NUMBER,
    ShipCountry NVARCHAR2(20)
);

CREATE TABLE Shippers(
    ShipperID NUMBER,
    CONSTRAINT Shippers_PK PRIMARY KEY (ShipperID),
    CompanyName NVARCHAR2(50) NOT NULL,
    Phone NUMBER
);

CREATE TABLE Customers(
    CustomerID NUMBER,
    CONSTRAINT Customer_PK PRIMARY KEY (CustomerID),
    CompanyName NVARCHAR2(50),
    CONSTRAINT Customer_FK FOREIGN KEY (CompanyName) REFERENCES Orders(ShipName),
    ContactName NVARCHAR2(50),
    ContactTitle NVARCHAR2(50),
    Address NVARCHAR2(50),
    City NVARCHAR2(20),
    Region NVARCHAR2(20),
    PostalCode NUMBER,
    Country NVARCHAR2(20),
    Phone NUMBER,
    Fax NUMBER
);

CREATE TABLE Employees(
    EmployeeID NUMBER,
    CONSTRAINT Employee_PK PRIMARY KEY (EmployeeID),
    LastName NVARCHAR2(50) NOT NULL,
    FirstName NVARCHAR2(50) NOT NULL,
    Title NVARCHAR2(50),
    TitleOfCourtesy NVARCHAR2(50),
    BirthDate TIMESTAMP,
    HireDate TIMESTAMP,
    Address NVARCHAR2(50),
    City NVARCHAR2(20),
    Region NVARCHAR2(20),
    PostalCode NUMBER,
    Country NVARCHAR2(50),
    HomePhone NVARCHAR2(50),
    Extension NVARCHAR2(20),
    Photo NVARCHAR2(100),
    Notes CLOB,
    ReportsTo NVARCHAR2(50)
);




