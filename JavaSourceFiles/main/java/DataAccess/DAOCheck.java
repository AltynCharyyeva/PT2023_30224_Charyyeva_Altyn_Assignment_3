package DataAccess;

import Model.Customer;
import Model.Product;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DAOCheck {
    public static void main(String[] args) {


     /*   CustomerDAO c = new CustomerDAO();
        ProductDAO p = new ProductDAO();
        Customer customer = c.findById(13, "customerId");
        System.out.println(customer);
        Product product = p.findById(13,"productId");
        System.out.println(product);*/

       // AbstractDAO dao = new ProductDAO();
        //dao.reflectionMethod(dao.findAll());

/*        AbstractDAO dao = new CustomerDAO();
        Customer c = new Customer("Charyyeva", "charyyeva@gmail.com", "Mary");
        dao.update(c, 31);*/

        AbstractDAO dao = new ProductDAO();
        BigDecimal bd = new BigDecimal("1.50");
        Product product = new Product("Banana", bd, 15);
        dao.update(product, 2);

/*        AbstractDAO dao = new ProductDAO();
        BigDecimal bd = new BigDecimal("3.99");
        Product p = new Product("Beans", bd, 30);
        dao.insert(p);*/

/*        AbstractDAO dao = new CustomerDAO();
        dao.checkProductQuantity("Banana");*/

        //List <Customer> customers = c.findAll();
        //List <Product> products = p.findAll();
        //System.out.println(customers);
        //System.out.println(products);


       // Customer customer = new Customer("R.Denny", "dennyrichards@gmail.com", "Wales");
       // CustomerDAO.insert(customer);

        //CustomerDAO.delete(c.getCustomerId());

    }
}
