package lesson6.table1;

public class Products {
    private int ProductID;
    private String ProductName;
    private Supplier supplier;
    private Categories category;
    private int QuantilyPerUnit;
    private int UnitPrice;
    private int UnitsInStock;
    private int UnitsOnOrder;
    private int ReorderLevel;
    private int Discontinued;

    public Products(int productID, String productName, Supplier supplier, Categories category, int quantilyPerUnit, int unitPrice, int unitsInStock, int unitsOnOrder, int reorderLevel, int discontinued) {
        ProductID = productID;
        ProductName = productName;
        this.supplier = supplier;
        this.category = category;
        QuantilyPerUnit = quantilyPerUnit;
        UnitPrice = unitPrice;
        UnitsInStock = unitsInStock;
        UnitsOnOrder = unitsOnOrder;
        ReorderLevel = reorderLevel;
        Discontinued = discontinued;
    }
}
