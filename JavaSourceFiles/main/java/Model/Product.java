package Model;

import java.math.BigDecimal;

public class Product {

    private int productId;
    private String productName;
    private BigDecimal productPrice;
    private int quantityInStock;

    public Product(int id, String name, BigDecimal price, int quantityInStock){
        this.productId=id;
        this.productName=name;
        this.productPrice=price;
        this.quantityInStock=quantityInStock;
    }

    public Product(String name, BigDecimal price, int quantityInStock){
        this.productName=name;
        this.productPrice=price;
        this.quantityInStock=quantityInStock;
    }

    public Product(){}

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    @Override
    public String toString() {
        return ("\nID: "+productId+"\nName: "+productName+"\nPrice: "+productPrice+"\nQuantity in stock: "+quantityInStock);
    }
}
