package com.Bean;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PRODUCT_SEQ")
    @SequenceGenerator(name="PRODUCT_SEQ", sequenceName="PRODUCT_SEQ", allocationSize=1)
    private int ProductId;
    private String ProductName;
    private int Quantity;
    private  int UnitPrice;
    private String Category;

    @UpdateTimestamp
    private LocalDateTime LastUpdated;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }

    public LocalDateTime getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public Product(int productId, String productName, int quantity, int unitPrice, String category) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        UnitPrice = unitPrice;
        Category = category;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", Quantity=" + Quantity +
                ", UnitPrice=" + UnitPrice +
                ", Category='" + Category + '\'' +
                ", LastUpdated=" + LastUpdated +
                ", createdDate=" + createdDate +
                '}';
    }


}
