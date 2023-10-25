package com.grocerybooking.GroceryBooking.repository;

import com.grocerybooking.GroceryBooking.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

}
