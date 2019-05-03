package hibernate.lesson2.DZ;

import hibernate.lesson2.Product;
import hibernate.lesson2.ProductDAO;

public class Demo {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("table new");
        product.setDescription("gdsgd");
        product.setPrice(89);

        ProductDAO.save(product);
    }
}
