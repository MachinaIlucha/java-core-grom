package lesson6.table1;

public class OrderDetails {
    private Orders order;
    private Products product;
    private int UnitPrice;
    private int Quantily;
    private int Discount;

    public OrderDetails(Orders order, Products product, int unitPrice, int quantily, int discount) {
        this.order = order;
        this.product = product;
        UnitPrice = unitPrice;
        Quantily = quantily;
        Discount = discount;
    }
}
