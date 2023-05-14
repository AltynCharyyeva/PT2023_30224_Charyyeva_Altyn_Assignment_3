package Presentation;

import DataAccess.AbstractDAO;
import DataAccess.CustomerDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.PreferencesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class View{

    private JFrame window = new JFrame("Orders management system");
    JLabel mainLabel = new JLabel("ORDERS MANAGEMENT SYSTEM");

    private JPanel mainPanel = new JPanel();
    private JButton clientOperationsBtn = new JButton("CLIENT OPERATIONS");
    private JButton productOperationsBtn = new JButton("PRODUCT OPERATIONS");
    private JButton createOrderBtn = new JButton("CREATE ORDERS");
    private JButton menu = new JButton("MAIN PAGE");


    private JPanel  clientOperationsPanel = new JPanel();
    private JTextField textField = new JTextField();
    private JButton addNewClientBtn = new JButton("Add new client");
    private JPanel addNewClientPanel = new JPanel();
    private JLabel addNewClientLabel = new JLabel("Fill the following blanks");
    private JButton editClientBtn = new JButton("Edit client");
    private JPanel editClientPanel = new JPanel();
    private JButton deleteClientBtn = new JButton("Delete client");
    private JPanel deleteClientPanel = new JPanel();
    private JButton viewClientsBtn = new JButton("View all clients in a table");
    private JPanel viewClientsPanel = new JPanel();
    private JLabel choseOperationsLabel1 = new JLabel("Choose one of the operations below about the client");

    private JTextField client = new JTextField();

    private JLabel ClientName = new JLabel("Name: ");
    private JTextField mail = new JTextField();
    private JLabel eMailAddress = new JLabel("Email: ");
    private JTextField address = new JTextField();
    private JLabel addressLabel = new JLabel("Address: ");
    private JButton addBtn = new JButton("ADD");

    private JLabel editLabel = new JLabel("Fill the following blanks");
    private JLabel editNameLabel = new JLabel("New name: ");
    private JTextField editName = new JTextField();
    private JLabel editMailLabel = new JLabel("New e-mail: ");
    private JTextField editMail = new JTextField();
    private JLabel editAddressLabel = new JLabel("New Addres: ");
    private JTextField editAddress = new JTextField();
    private JButton editBtn = new JButton("EDIT");
    private JLabel clientIdLabel = new JLabel("Client ID: ");
    private JTextField clientId = new JTextField();
    private JLabel deletePanelLabel = new JLabel("Fill the following blanks");
    private JTextField deleteClient = new JTextField();
    private JLabel deleteClientLabel = new JLabel("Client ID: ");
    private JButton deleteBtn = new JButton("DELETE");
    private JTextArea viewClients = new JTextArea();
    private JLabel viewClientsLabel = new JLabel("All the clients in a table");
    private JPanel productOperationsPanel = new JPanel();
    private JPanel addNewProductPanel = new JPanel();
    private JPanel editProductPanel = new JPanel();
    private JPanel deleteProductPanel = new JPanel();
    private JPanel viewProductsPanel = new JPanel();
    private JLabel choseOperationsLabel2 = new JLabel("Choose one of the operations about the product");
    private JButton addNewProductBtn = new JButton("Add new product");
    private JButton editProductBtn = new JButton("Edit Product");
    private JButton deleteProductBtn = new JButton("Delete Product");
    private JButton viewProductsBtn = new JButton("View all the products in a table");

    private JLabel addNewProductLabel = new JLabel("");
    private JLabel productName = new JLabel("Name: ");
    private JTextField product = new JTextField();
    private JLabel productPriceLabel = new JLabel("Price:");
    private JTextField price = new JTextField();
    private JLabel productInStockLabel = new JLabel("Quantity in stock:");
    private JTextField productInStock = new JTextField();

    private JPanel createOrderPanel = new JPanel();
    private JLabel makeOrderLabel = new JLabel("Make order");
    private JButton addProductBtn = new JButton("ADD");

    private JLabel editProductLabel = new JLabel("Fill the following blanks");
    private JLabel editProductNameLabel = new JLabel("New name: ");
    private JTextField editProductName = new JTextField();
    private JLabel editPriceLabel = new JLabel("New price: ");
    private JTextField editPrice = new JTextField();
    private JLabel editQuantityLabel = new JLabel("New quantity: ");
    private JTextField editQuantity = new JTextField();
    private JButton editProductBttn = new JButton("EDIT");
    private JLabel deleteProductPanelLabel = new JLabel("Fill in the following blanks");
    private JTextField deleteProduct = new JTextField();
    private JLabel deleteProductLabel = new JLabel("ID");
    private JButton deleteProductPBtn = new JButton("DELETE");

    private JScrollPane clientScrollPane = new JScrollPane();
    private JScrollPane productScrollPane = new JScrollPane();
    private JLabel viewProductsLabel = new JLabel("All the products in a table");

    private JLabel clientNameForOrderLabel = new JLabel("Client Name: ");
    private JLabel productNameForOrderLabel = new JLabel("Product Name: ");
    private JLabel quantityForOrderLabel = new JLabel("Quantity: ");
    private JTextField clientNameForOrder = new JTextField();
    private JTextField productNameForOrder = new JTextField();
    private JTextField quantityForOrder = new JTextField();
    private JButton makeOrderBtn = new JButton("Make Order");

    private JLabel editOldProductLabel = new JLabel("Product ID: ");
    private JTextField editOldProduct = new JTextField();





    public View(){


        /*-----------------------Window-------------------------------------------*/
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(1400, 750);
        window.getContentPane().setBackground(new Color(203, 195, 227));
        window.setResizable(false);
        window.setLayout(null);
        /*-----------------------------------------------------------------------*/

        mainLabel.setBounds(450, 0, 500, 100);
        mainLabel.setFont(new Font("New Times Roman", Font.PLAIN, 19));
        mainLabel.setForeground(new Color(100, 100, 240));

        /*-----------------------Main_Panel-------------------------------------*/
        mainPanel.setBackground(new Color(200, 200, 200));
        mainPanel.setBounds(450, 70, 300, 550);
        mainPanel.setLayout(null);

        menu.setBounds(10, 60, 275, 35);
        menu.setFont(new Font("Calibri", Font.PLAIN, 15));
        menu.setHorizontalAlignment(JTextField.CENTER);
        menu.setBackground(new Color(203, 195, 227));
        menu.setForeground(new Color(160, 32, 240));
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBounds(450, 70, 300, 550);
                clientOperationsBtn.setBackground(new Color(203, 195, 227));
                clientOperationsBtn.setForeground(new Color(160, 32, 240));
                productOperationsBtn.setBackground(new Color(203, 195, 227));
                productOperationsBtn.setForeground(new Color(160, 32, 240));
                createOrderBtn.setBackground(new Color(203, 195, 227));
                createOrderBtn.setForeground(new Color(160, 32, 240));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
                clientOperationsPanel.setVisible(false);
                productOperationsPanel.setVisible(false);
                createOrderPanel.setVisible(false);
                //addNewClientPanel.setVisible(false);
                //editClientPanel.setVisible(false);
                //deleteClientPanel.setVisible(false);
                //viewClientsPanel.setVisible(false);
            }
        });


        clientOperationsBtn.setBounds(10, 110, 275, 35);
        clientOperationsBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        clientOperationsBtn.setHorizontalAlignment(JTextField.CENTER);
        clientOperationsBtn.setBackground(new Color(203, 195, 227));
        clientOperationsBtn.setForeground(new Color(160, 32, 240));
        clientOperationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBounds(20,70, 300, 550);
                clientOperationsBtn.setForeground(new Color(48, 25, 52));
                clientOperationsBtn.setBackground(new Color(160, 132, 227));
                productOperationsBtn.setBackground(new Color(203, 195, 227));
                productOperationsBtn.setForeground(new Color(160, 32, 240));
                createOrderBtn.setBackground(new Color(203, 195, 227));
                createOrderBtn.setForeground(new Color(160, 32, 240));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
                clientOperationsPanel.setVisible(true);
                productOperationsPanel.setVisible(false);
                createOrderPanel.setVisible(false);
                //addNewClientPanel.setVisible(false);
                //editClientPanel.setVisible(false);
                //deleteClientPanel.setVisible(false);
                //viewClientsPanel.setVisible(false);
            }
        });

        productOperationsBtn.setBounds(10, 155, 275, 35);
        productOperationsBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        productOperationsBtn.setHorizontalAlignment(JTextField.CENTER);
        productOperationsBtn.setBackground(new Color(203, 195, 227));
        productOperationsBtn.setForeground(new Color(160, 32, 240));
        productOperationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBounds(20,70, 300, 550);
                productOperationsBtn.setForeground(new Color(48, 25, 52));
                productOperationsBtn.setBackground(new Color(160, 132, 227));
                clientOperationsBtn.setBackground(new Color(203, 195, 227));
                clientOperationsBtn.setForeground(new Color(160, 32, 240));
                createOrderBtn.setBackground(new Color(203, 195, 227));
                createOrderBtn.setForeground(new Color(160, 32, 240));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
                productOperationsPanel.setVisible(true);
                clientOperationsPanel.setVisible(false);
                createOrderPanel.setVisible(false);
                //addNewClientPanel.setVisible(false);
                //editClientPanel.setVisible(false);
                //deleteClientPanel.setVisible(false);
                //viewClientsPanel.setVisible(false);
            }
        });

        createOrderBtn.setBounds(10, 200, 275, 35);
        createOrderBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        createOrderBtn.setHorizontalAlignment(JTextField.CENTER);
        createOrderBtn.setBackground(new Color(203, 195, 227));
        createOrderBtn.setForeground(new Color(160, 32, 240));
        createOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBounds(20,70, 300, 550);
                createOrderBtn.setForeground(new Color(48, 25, 52));
                createOrderBtn.setBackground(new Color(160, 132, 227));
                productOperationsBtn.setBackground(new Color(203, 195, 227));
                productOperationsBtn.setForeground(new Color(160, 32, 240));
                clientOperationsBtn.setBackground(new Color(203, 195, 227));
                clientOperationsPanel.setForeground(new Color(160, 32, 240));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
                createOrderPanel.setVisible(true);
                productOperationsPanel.setVisible(false);
                clientOperationsPanel.setVisible(false);
                //addNewClientPanel.setVisible(false);
                //editClientPanel.setVisible(false);
                //deleteClientPanel.setVisible(false);
                //viewClientsPanel.setVisible(false);
            }
        });


        mainPanel.add(clientOperationsBtn);
        mainPanel.add(productOperationsBtn);
        mainPanel.add(createOrderBtn);
        mainPanel.add(menu);
        /*---------------------------------------------------------------------------------------------------*/




        /*------------------------Client_Operations_Panel----------------------------------------------------*/
        clientOperationsPanel.setBackground(new Color(200, 200, 200));
        clientOperationsPanel.setBounds(330, 70, 1000, 550);
        clientOperationsPanel.setLayout(null);
        clientOperationsPanel.setVisible(false);

        choseOperationsLabel1.setBounds(50, 15, 400, 90);
        choseOperationsLabel1.setForeground(new Color(100, 32, 240));
        choseOperationsLabel1.setFont(new Font("Calibri", Font.PLAIN, 17));


        addNewClientBtn.setBounds(50, 100, 230, 35);
        addNewClientBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        addNewClientBtn.setBackground(new Color(203, 195, 227));
        addNewClientBtn.setForeground(new Color(160, 32, 240));
        addNewClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewClientPanel.setVisible(true);
                addNewClientBtn.setBackground(new Color(160, 132, 227));
                addNewClientBtn.setForeground(new Color(48, 25, 52));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
                editClientPanel.setVisible(false);
                deleteClientPanel.setVisible(false);
                viewClientsPanel.setVisible(false);
            }
        });

        addNewClientPanel.setBackground(new Color(200, 160, 200));
        addNewClientPanel.setBounds(300, 90, 650, 380);
        addNewClientPanel.setLayout(null);
        addNewClientPanel.setVisible(false);

        addNewClientLabel.setForeground(new Color(100, 32, 240));
        addNewClientLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        addNewClientLabel.setBounds(20, 15, 250, 35);

        client.setFont(new Font("Calibri", Font.PLAIN, 17));
        client.setBounds(80, 60, 280, 25);
        client.setEnabled(true);
        ClientName.setFont(new Font("Calibri", Font.PLAIN, 17));
        ClientName.setForeground(new Color(100, 32, 240));
        ClientName.setBounds(20, 60, 80, 25);

        mail.setFont(new Font("Calibri", Font.PLAIN, 17));
        mail.setBounds(80, 95, 280, 25);
        mail.setEnabled(true);
        eMailAddress.setFont(new Font("Calibri", Font.PLAIN, 17));
        eMailAddress.setForeground(new Color(100, 32, 240));
        eMailAddress.setBounds(20, 95, 80, 25);

        address.setFont(new Font("Calibri", Font.PLAIN, 17));
        address.setBounds(80, 130, 280, 25);
        address.setEnabled(true);
        addressLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        addressLabel.setForeground(new Color(100, 32, 240));
        addressLabel.setBounds(20, 130, 80, 25);

        addBtn.setBounds(350, 300, 80, 35);
        addBtn.setBackground(new Color(160, 132, 227));
        addBtn.setForeground(new Color(48, 25, 52));



        addNewClientPanel.add(ClientName);
        addNewClientPanel.add(addNewClientLabel);
        addNewClientPanel.add(client);
        addNewClientPanel.add(mail);
        addNewClientPanel.add(eMailAddress);
        addNewClientPanel.add(address);
        addNewClientPanel.add(addressLabel);
        addNewClientPanel.add(addBtn);



        editClientBtn.setBounds(50, 155, 230, 35);
        editClientBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        editClientBtn.setBackground(new Color(203, 195, 227));
        editClientBtn.setForeground(new Color(160, 32, 240));
        editClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editClientPanel.setVisible(true);
                addNewClientPanel.setVisible(false);
                deleteClientPanel.setVisible(false);
                viewClientsPanel.setVisible(false);
                editClientBtn.setBackground(new Color(160, 132, 227));
                editClientBtn.setForeground(new Color(48, 25, 52));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
            }
        });


        editClientPanel.setBackground(new Color(200, 160, 200));
        editClientPanel.setBounds(300, 90, 650, 380);
        editClientPanel.setLayout(null);
        editClientPanel.setVisible(false);

        editLabel.setForeground(new Color(100, 32, 240));
        editLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editLabel.setBounds(20, 15, 250, 35);


        clientId.setFont(new Font("Calibri", Font.PLAIN, 17));
        clientId.setBounds(120, 60, 280, 25);
        clientId.setEnabled(true);
        clientIdLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        clientIdLabel.setForeground(new Color(100, 32, 240));
        clientIdLabel.setBounds(20, 60, 100, 25);


        editName.setFont(new Font("Calibri", Font.PLAIN, 17));
        editName.setBounds(120, 95, 280, 25);
        editName.setEnabled(true);
        editNameLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editNameLabel.setForeground(new Color(100, 32, 240));
        editNameLabel.setBounds(20, 95, 100, 25);

        editMail.setFont(new Font("Calibri", Font.PLAIN, 17));
        editMail.setBounds(120, 130, 280, 25);
        editMail.setEnabled(true);
        editMailLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editMailLabel.setForeground(new Color(100, 32, 240));
        editMailLabel.setBounds(20, 130, 100, 25);

        editAddress.setFont(new Font("Calibri", Font.PLAIN, 17));
        editAddress.setBounds(120, 165, 280, 25);
        editAddress.setEnabled(true);
        editAddressLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editAddressLabel.setForeground(new Color(100, 32, 240));
        editAddressLabel.setBounds(20, 165, 100, 25);

        editBtn.setBounds(350, 300, 80, 35);
        editBtn.setBackground(new Color(160, 132, 227));
        editBtn.setForeground(new Color(48, 25, 52));

        editClientPanel.add(editLabel);
        editClientPanel.add(editName);
        editClientPanel.add(editNameLabel);
        editClientPanel.add(editMail);
        editClientPanel.add(editMailLabel);
        editClientPanel.add(editAddress);
        editClientPanel.add(editAddressLabel);
        editClientPanel.add(clientId);
        editClientPanel.add(clientIdLabel);
        editClientPanel.add(editBtn);




        deleteClientBtn.setBounds(50, 210, 230, 35);
        deleteClientBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        deleteClientBtn.setBackground(new Color(203, 195, 227));
        deleteClientBtn.setForeground(new Color(160, 32, 240));
        deleteClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClientPanel.setVisible(true);
                addNewClientPanel.setVisible(false);
                editClientPanel.setVisible(false);
                viewClientsPanel.setVisible(false);
                deleteClientBtn.setBackground(new Color(160, 132, 227));
                deleteClientBtn.setForeground(new Color(48, 25, 52));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                viewClientsBtn.setBackground(new Color(203, 195, 227));
                viewClientsBtn.setForeground(new Color(160, 32, 240));
            }
        });


        deleteClientPanel.setBackground(new Color(200, 160, 200));
        deleteClientPanel.setBounds(300, 90, 650, 380);
        deleteClientPanel.setLayout(null);
        deleteClientPanel.setVisible(false);

        deletePanelLabel.setForeground(new Color(100, 32, 240));
        deletePanelLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        deletePanelLabel.setBounds(20, 15, 250, 35);

        deleteClient.setFont(new Font("Calibri", Font.PLAIN, 17));
        deleteClient.setBounds(120, 60, 280, 25);
        deleteClient.setEnabled(true);
        deleteClientLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        deleteClientLabel.setForeground(new Color(100, 32, 240));
        deleteClientLabel.setBounds(20, 60, 100, 25);

        deleteBtn.setBounds(350, 300, 100, 35);
        deleteBtn.setBackground(new Color(160, 132, 227));
        deleteBtn.setForeground(new Color(48, 25, 52));

        deleteClientPanel.add(deletePanelLabel);
        deleteClientPanel.add(deleteClientLabel);
        deleteClientPanel.add(deleteClient);
        deleteClientPanel.add(deleteBtn);


        viewClientsBtn.setBounds(50, 265, 230, 35);
        viewClientsBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        viewClientsBtn.setBackground(new Color(203, 195, 227));
        viewClientsBtn.setForeground(new Color(160, 32, 240));
        viewClientsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewClientsPanel.setVisible(true);
                addNewClientPanel.setVisible(false);
                editClientPanel.setVisible(false);
                deleteClientPanel.setVisible(false);
                viewClientsBtn.setBackground(new Color(160, 132, 227));
                viewClientsBtn.setForeground(new Color(48, 25, 52));
                deleteClientBtn.setBackground(new Color(203, 195, 227));
                deleteClientBtn.setForeground(new Color(160, 32, 240));
                editClientBtn.setBackground(new Color(203, 195, 227));
                editClientBtn.setForeground(new Color(160, 32, 240));
                addNewClientBtn.setBackground(new Color(203, 195, 227));
                addNewClientBtn.setForeground(new Color(160, 32, 240));

            }
        });

        viewClientsPanel.setBackground(new Color(200, 160, 200));
        viewClientsPanel.setBounds(290, 90, 650, 450);
        viewClientsPanel.setLayout(null);
        viewClientsPanel.setVisible(false);



        viewClientsLabel.setForeground(new Color(100, 32, 240));
        viewClientsLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        viewClientsLabel.setBounds(20, 5, 250, 35);

        clientScrollPane.setBounds(30, 30, 620, 440);
        clientScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
/*        scrollPane.getViewport().add(AbstractDAO.getTable());
        AbstractDAO.getTable().setFillsViewportHeight(true);*/



        viewClientsPanel.add(viewClientsLabel);
        viewClientsPanel.add(clientScrollPane);


        clientOperationsPanel.add(choseOperationsLabel1);
        clientOperationsPanel.add(addNewClientBtn);
        clientOperationsPanel.add(editClientBtn);
        clientOperationsPanel.add(deleteClientBtn);
        clientOperationsPanel.add(viewClientsBtn);
        clientOperationsPanel.add(addNewClientPanel);
        clientOperationsPanel.add(editClientPanel);
        clientOperationsPanel.add(deleteClientPanel);
        clientOperationsPanel.add(viewClientsPanel);



        /*---------------------------------------------------------------------------------------------------*/

        /*------------------------Product_Operations_Panel----------------------------------------------------*/

        productOperationsPanel.setBackground(new Color(200, 200, 200));
        productOperationsPanel.setBounds(330, 70, 1000, 550);
        productOperationsPanel.setLayout(null);
        productOperationsPanel.setVisible(false);

        choseOperationsLabel2.setBounds(50, 15, 400, 90);
        choseOperationsLabel2.setForeground(new Color(100, 32, 240));
        choseOperationsLabel2.setFont(new Font("Calibri", Font.PLAIN, 17));


        addNewProductBtn.setBounds(50, 100, 250, 35);
        addNewProductBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        addNewProductBtn.setBackground(new Color(203, 195, 227));
        addNewProductBtn.setForeground(new Color(160, 32, 240));
        addNewProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewProductPanel.setVisible(true);
                editProductPanel.setVisible(false);
                deleteProductPanel.setVisible(false);
                viewProductsPanel.setVisible(false);

            }
        });

        addNewProductPanel.setBackground(new Color(200, 160, 200));
        addNewProductPanel.setBounds(320, 90, 650, 380);
        addNewProductPanel.setLayout(null);
        addNewProductPanel.setVisible(false);


        productName.setFont(new Font("Calibri", Font.PLAIN, 17));
        productName.setForeground(new Color(100, 32, 240));
        productName.setBounds(20, 60, 145, 25);
        product.setFont(new Font("Calibri", Font.PLAIN, 17));
        product.setBounds(145, 60, 280, 25);
        product.setEnabled(true);

        productPriceLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        productPriceLabel.setForeground(new Color(100, 32, 240));
        productPriceLabel.setBounds(20, 95, 145, 25);
        price.setFont(new Font("Calibri", Font.PLAIN, 17));
        price.setBounds(145, 95, 280, 25);
        price.setEnabled(true);

        productInStockLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        productInStockLabel.setForeground(new Color(100, 32, 240));
        productInStockLabel.setBounds(20, 130, 145, 25);
        productInStock.setFont(new Font("Calibri", Font.PLAIN, 17));
        productInStock.setBounds(145, 130, 280, 25);
        productInStock.setEnabled(true);

        addProductBtn.setBounds(350, 300, 80, 35);
        addProductBtn.setBackground(new Color(160, 132, 227));
        addProductBtn.setForeground(new Color(48, 25, 52));

        addNewProductPanel.add(editLabel);
        addNewProductPanel.add(productName);
        addNewProductPanel.add(productPriceLabel);
        addNewProductPanel.add(productInStockLabel);
        addNewProductPanel.add(product);
        addNewProductPanel.add(price);
        addNewProductPanel.add(productInStock);
        addNewProductPanel.add(addProductBtn);

        editProductBtn.setBounds(50, 155, 250, 35);
        editProductBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        editProductBtn.setBackground(new Color(203, 195, 227));
        editProductBtn.setForeground(new Color(160, 32, 240));
        editProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProductPanel.setVisible(true);
                addNewProductPanel.setVisible(false);
                deleteProductPanel.setVisible(false);
                viewProductsPanel.setVisible(false);
            }
        });

        editProductPanel.setBackground(new Color(200, 160, 200));
        editProductPanel.setBounds(320, 90, 650, 380);
        editProductPanel.setLayout(null);
        editProductPanel.setVisible(false);

        editOldProductLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editOldProductLabel.setForeground(new Color(100, 32, 240));
        editOldProductLabel.setBounds(20, 60, 145, 25);
        editOldProduct.setFont(new Font("Calibri", Font.PLAIN, 17));
        editOldProduct.setBounds(145, 60, 280, 25);
        editOldProduct.setEnabled(true);

        editProductNameLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editProductNameLabel.setForeground(new Color(100, 32, 240));
        editProductNameLabel.setBounds(20, 95, 145, 25);
        editProductName.setFont(new Font("Calibri", Font.PLAIN, 17));
        editProductName.setBounds(145, 95, 280, 25);
        editProductName.setEnabled(true);

        editPriceLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editPriceLabel.setForeground(new Color(100, 32, 240));
        editPriceLabel.setBounds(20, 130, 145, 25);
        editPrice.setFont(new Font("Calibri", Font.PLAIN, 17));
        editPrice.setBounds(145, 130, 280, 25);
        editPrice.setEnabled(true);

        editQuantityLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        editQuantityLabel.setForeground(new Color(100, 32, 240));
        editQuantityLabel.setBounds(20, 175, 145, 25);
        editQuantity.setFont(new Font("Calibri", Font.PLAIN, 17));
        editQuantity.setBounds(145, 175, 280, 25);
        editQuantity.setEnabled(true);

        editProductBttn.setBounds(350, 300, 80, 35);
        editProductBttn.setBackground(new Color(160, 132, 227));
        editProductBttn.setForeground(new Color(48, 25, 52));


        editProductPanel.add(editProductName);
        editProductPanel.add(editProductNameLabel);
        editProductPanel.add(editPrice);
        editProductPanel.add(editPriceLabel);
        editProductPanel.add(editQuantity);
        editProductPanel.add(editQuantityLabel);
        editProductPanel.add(editProductBttn);
        editProductPanel.add(editOldProduct);
        editProductPanel.add(editOldProductLabel);



        deleteProductBtn.setBounds(50, 210, 250, 35);
        deleteProductBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        deleteProductBtn.setBackground(new Color(203, 195, 227));
        deleteProductBtn.setForeground(new Color(160, 32, 240));
        deleteProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProductPanel.setVisible(true);
                addNewProductPanel.setVisible(false);
                editProductPanel.setVisible(false);
                viewProductsPanel.setVisible(false);
            }
        });


        deleteProductPanel.setBackground(new Color(200, 160, 200));
        deleteProductPanel.setBounds(300, 90, 650, 380);
        deleteProductPanel.setLayout(null);
        deleteProductPanel.setVisible(false);

        deleteProductPanelLabel.setForeground(new Color(100, 32, 240));
        deleteProductPanelLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        deleteProductPanelLabel.setBounds(20, 15, 250, 35);

        deleteProduct.setFont(new Font("Calibri", Font.PLAIN, 17));
        deleteProduct.setBounds(120, 60, 280, 25);
        deleteProduct.setEnabled(true);
        deleteProductLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        deleteProductLabel.setForeground(new Color(100, 32, 240));
        deleteProductLabel.setBounds(20, 60, 100, 25);

        deleteProductPBtn.setBounds(350, 300, 100, 35);
        deleteProductPBtn.setBackground(new Color(160, 132, 227));
        deleteProductPBtn.setForeground(new Color(48, 25, 52));

        deleteProductPanel.add(deleteProductPanelLabel);
        deleteProductPanel.add(deleteProduct);
        deleteProductPanel.add(deleteProductLabel);
        deleteProductPanel.add(deleteProductPBtn);



        viewProductsBtn.setBounds(50, 265, 250, 35);
        viewProductsBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
        viewProductsBtn.setBackground(new Color(203, 195, 227));
        viewProductsBtn.setForeground(new Color(160, 32, 240));
        viewProductsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProductsPanel.setVisible(true);
                addNewProductPanel.setVisible(false);
                editProductPanel.setVisible(false);
                deleteProductPanel.setVisible(false);
            }
        });

        viewProductsPanel.setBackground(new Color(200, 160, 200));
        viewProductsPanel.setBounds(310, 90, 650, 450);
        viewProductsPanel.setLayout(null);
        viewProductsPanel.setVisible(false);

        viewProductsLabel.setForeground(new Color(100, 32, 240));
        viewProductsLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        viewProductsLabel.setBounds(20, 5, 250, 35);

        productScrollPane.setBounds(30, 30, 620, 440);
        productScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        viewProductsPanel.add(viewProductsLabel);
        viewProductsPanel.add(productScrollPane);



        productOperationsPanel.add(choseOperationsLabel2);
        productOperationsPanel.add(addNewProductBtn);
        productOperationsPanel.add(editProductBtn);
        productOperationsPanel.add(deleteProductBtn);
        productOperationsPanel.add(viewProductsBtn);
        productOperationsPanel.add(addNewProductPanel);
        productOperationsPanel.add(editProductPanel);
        productOperationsPanel.add(deleteProductPanel);
        productOperationsPanel.add(viewProductsPanel);

        /*--------------------------------------------------------------------------------------------------------*/

        /*------------------------Create_Orders_Panel------------------------------------------------------------*/

        createOrderPanel.setBackground(new Color(200, 200, 200));
        createOrderPanel.setBounds(330, 70, 1000, 550);
        createOrderPanel.setLayout(null);
        createOrderPanel.setVisible(false);

        makeOrderLabel.setBounds(50, 50, 300, 70);
        makeOrderLabel.setForeground(new Color(160, 32, 240));
        makeOrderLabel.setFont(new Font("Calibri", Font.PLAIN, 17));

        clientNameForOrderLabel.setForeground(new Color(100, 32, 240));
        clientNameForOrderLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        clientNameForOrderLabel.setBounds(100, 100, 120, 35);
        clientNameForOrder.setFont(new Font("Calibri", Font.PLAIN, 17));
        clientNameForOrder.setBounds(210, 100, 280, 25);
        clientNameForOrder.setEnabled(true);

        productNameForOrderLabel.setForeground(new Color(100, 32, 240));
        productNameForOrderLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        productNameForOrderLabel.setBounds(100, 155, 120, 35);
        productNameForOrder.setFont(new Font("Calibri", Font.PLAIN, 17));
        productNameForOrder.setBounds(210, 155, 280, 25);
        productNameForOrder.setEnabled(true);

        quantityForOrderLabel.setForeground(new Color(100, 32, 240));
        quantityForOrderLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
        quantityForOrderLabel.setBounds(100, 205, 120, 35);
        quantityForOrder.setFont(new Font("Calibri", Font.PLAIN, 17));
        quantityForOrder.setBounds(210, 205, 280, 25);
        quantityForOrder.setEnabled(true);

        makeOrderBtn.setBounds(700, 400, 150, 35);
        makeOrderBtn.setBackground(new Color(160, 132, 227));
        makeOrderBtn.setForeground(new Color(48, 25, 52));






        createOrderPanel.add(makeOrderLabel);
        createOrderPanel.add(clientNameForOrderLabel);
        createOrderPanel.add(clientNameForOrder);
        createOrderPanel.add(productNameForOrderLabel);
        createOrderPanel.add(productNameForOrder);
        createOrderPanel.add(quantityForOrder);
        createOrderPanel.add(quantityForOrderLabel);
        createOrderPanel.add(makeOrderBtn);

        /*--------------------------------------------------------------------------------------------------------*/


        window.add(mainPanel);
        window.add(mainLabel);
        window.add(clientOperationsPanel);
        window.add(productOperationsPanel);
        window.add(createOrderPanel);


    }


    public String getAddNewClientName(){
        return client.getText();
    }

    public String getAddNewClientMail(){
        return mail.getText();
    }

    public String getAddNewClientAddress(){
        return address.getText();
    }

    public String getClientNameForOrder(){
        return  clientNameForOrder.getText();
    }

    public String getProductNameForOrder(){
        return productNameForOrder.getText();
    }

    public String getQuantityForOrder(){
        return quantityForOrder.getText();
    }

    public String getEditClientName(){
        return editName.getText();
    }

    public String getEditClientMail(){
        return editMail.getText();
    }

    public String getEditClientAddress(){
        return editAddress.getText();
    }


    public void showError(String errMessage){
        JOptionPane.showMessageDialog(addNewClientPanel, errMessage);
    }

    public void addAddNewClientBtnListener(ActionListener addClient){
        addBtn.addActionListener(addClient);
    }
    public void addNewProductBtnListener(ActionListener addProduct){
        addProductBtn.addActionListener(addProduct);
    }
    public void addEditClientBtnListener(ActionListener editClient){
        editBtn.addActionListener(editClient);
    }
    public String getAddNewProductName(){
        return product.getText();
    }
    public String getAddNewProductPrice(){
        return price.getText();
    }

    public String getAddNewProductQuantity(){
        return productInStock.getText();
    }
    public String getClientId(){
        return clientId.getText();
    }

    public String getEditProductName(){
        return editProductName.getText();
    }
    public String getEditProductPrice(){
        return editPrice.getText();
    }

    public String getEditProductQuantity(){
        return editQuantity.getText();
    }

    public String getOldProductId(){
        return editOldProduct.getText();
    }


    public void addEditProductBttnListener(ActionListener editProduct){
        editProductBttn.addActionListener(editProduct);
    }

    public void addViewClientsListener(ActionListener scrollPaneListener){
        viewClientsBtn.addActionListener(scrollPaneListener);
    }

    public void addViewProductsListener(ActionListener scrollPaneListener){
        viewProductsBtn.addActionListener(scrollPaneListener);
    }

    public void addMakeOrderListener(ActionListener makeOrderListener){
        makeOrderBtn.addActionListener(makeOrderListener);
    }

    public JScrollPane getClientScrollPane(){
        return clientScrollPane;
    }

    public JScrollPane getProductScrollPane(){
        return productScrollPane;
    }

    public JPanel getCreateOrderPanel(){
        return createOrderPanel;
    }



}
