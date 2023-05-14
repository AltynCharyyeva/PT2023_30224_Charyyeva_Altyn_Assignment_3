package Presentation;

import DataAccess.AbstractDAO;
import DataAccess.CustomerDAO;
import DataAccess.ProductDAO;
import Model.Customer;
import Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;

public class Controller {
    private  View view;

    public Controller(View v){
        this.view=v;

        this.view.addAddNewClientBtnListener(new addNewClientBtnListener());
        this.view.addViewClientsListener(new viewClientsListenerClass());
        this.view.addViewProductsListener(new viewProductsListener());
        this.view.addMakeOrderListener(new makeOrderListener());
        this.view.addNewProductBtnListener(new addNewProductBtnListener());
        this.view.addEditClientBtnListener(new editClientBtnListener());
        this.view.addEditProductBttnListener(new editProductBtnListener());
    }

     class addNewClientBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           String name = view.getAddNewClientName();;
           String mail = view.getAddNewClientMail();;
           String address = view.getAddNewClientAddress();
           Customer customer = new Customer(name, mail, address);
           AbstractDAO dao = new CustomerDAO();
           dao.insert(customer);
           System.out.println("Done");

        }

    }

    class addNewProductBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String name = view.getAddNewProductName();;
            String price = view.getAddNewProductPrice();;
            String quantityInStock = view.getAddNewProductQuantity();
            BigDecimal bd = new BigDecimal(price);
            int quantity = Integer.parseInt(quantityInStock);
            Product product = new Product(name, bd, quantity);
            AbstractDAO dao = new ProductDAO();
            dao.insert(product);
            System.out.println("Done");
        }

    }

    class editClientBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String clientId = view.getClientId();
            int id = Integer.parseInt(clientId);
            String name = view.getEditClientName();;
            String mail = view.getEditClientMail();;
            String address = view.getEditClientAddress();
            Customer customer = new Customer(name, mail, address);
            AbstractDAO dao = new CustomerDAO();
            dao.update(customer, id);
            System.out.println("Done");

        }

    }

    class editProductBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String productId = view.getOldProductId();
            int id = Integer.parseInt(productId);
            String productName = view.getEditProductName();
            String productPrice = view.getEditProductPrice();
            BigDecimal price = new BigDecimal(productPrice);
            String productQuantity = view.getEditProductQuantity();
            int quantity = Integer.parseInt(productQuantity);
            Product product = new Product(productName, price, quantity);
            AbstractDAO dao = new ProductDAO();
            dao.update(product, id);
        }
    }

    class viewClientsListenerClass implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JScrollPane scrollPane = view.getClientScrollPane();
            AbstractDAO dao = new CustomerDAO();
            JTable table = new JTable(dao.getTableUsingReflecton(dao.findAll()));
            table.getColumnModel().getColumn(0).setPreferredWidth(3);
            table.getColumnModel().getColumn(1).setPreferredWidth(20);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(35);
            scrollPane.getViewport().add(table);
        }
    }

    class viewProductsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JScrollPane scrollPane = view.getProductScrollPane();
            AbstractDAO dao = new ProductDAO();
            JTable table = new JTable(dao.getTableUsingReflecton(dao.findAll()));
            table.getColumnModel().getColumn(0).setPreferredWidth(3);
            table.getColumnModel().getColumn(1).setPreferredWidth(20);
            table.getColumnModel().getColumn(2).setPreferredWidth(10);
            table.getColumnModel().getColumn(3).setPreferredWidth(10);
            scrollPane.getViewport().add(table);
        }
    }

    class makeOrderListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String clientName = view.getClientNameForOrder();
            String productName = view.getProductNameForOrder();
            String quan = view.getQuantityForOrder();
            int quantity = Integer.parseInt(quan);

            AbstractDAO dao = new CustomerDAO();
            if(dao.makeOrder(clientName, productName, quantity)){
                JOptionPane.showMessageDialog(view.getCreateOrderPanel(), "Order successfully made");
            }else{
                JOptionPane.showMessageDialog(view.getCreateOrderPanel(), "Product quantity is under 0!");
            }
        }
    }


}
