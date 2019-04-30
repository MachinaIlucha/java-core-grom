package lesson5.DZ;

import lesson5.Product;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class ProductRepository {

    public static void main(String[] args) {
        delete(99);
    }

    public static void save(Product product) {
        Session session = new HibernateUtils().createSession().openSession();
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(long id){
        Session session = new HibernateUtils().createSession().openSession();
        session.getTransaction().begin();
        session.delete(findById(id));
        session.getTransaction().commit();
        session.close();
    }

    public static void update(Product product){
        Session session = new HibernateUtils().createSession().openSession();
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

    public static Product findById(long id){
        Session session = new HibernateUtils().createSession().openSession();
        session.getTransaction().begin();
        Product product;
        product = session.load(Product.class , id);
        Hibernate.initialize(product);
        session.close();
        return product;
    }
}
