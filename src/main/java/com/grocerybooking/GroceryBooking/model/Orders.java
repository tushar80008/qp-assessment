package com.grocerybooking.GroceryBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_quantity")
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "sku")
    private Grocery grocery;

    public Orders() {
    }

    public Orders(int quantity, Grocery grocery) {
        this.quantity = quantity;
        this.grocery = grocery;
    }

    public Long getId() {
        return id;
    }

    public Grocery getGrocery() {
        return grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "quantity=" + quantity +
                ", grocery=" + grocery +
                '}';
    }
}
