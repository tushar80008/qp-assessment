package com.grocerybooking.GroceryBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grocery")
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku")
    private Long id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_price")
    private Double itemPrice;
    @Column(name = "stock")
    private int stock;
    @Column(name = "sales_status")
    private boolean salesStatus;

    @OneToOne(mappedBy = "grocery")
    private Orders orders;
    public Grocery() {
    }

    public Grocery(String itemName, Double itemPrice, int stock, boolean salesStatus) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.stock = stock;
        this.salesStatus = salesStatus;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(boolean salesStatus) {
        this.salesStatus = salesStatus;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", stock=" + stock +
                ", salesStatus=" + salesStatus +
                ", orders=" + orders +
                '}';
    }
}
