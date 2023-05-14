package Model;

public class Customer {

    private int customerId;
    private String customerName;
    private String customerMail;
    private String customerAddress;

    public Customer(int id, String name, String mail, String address){
        this.customerId=id;
        this.customerName=name;
        this.customerMail=mail;
        this.customerAddress=address;
    }

    public Customer(String name, String mail, String address){
        this.customerName=name;
        this.customerMail=mail;
        this.customerAddress=address;
    }
    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String toString(){
        return ("\nID: "+customerId+"\nName: "+customerName+"\nMail: "+customerMail+"\nAddress: "+customerAddress);
    }
}
