package com.grocerybooking.GroceryBooking.repository;

import com.grocerybooking.GroceryBooking.model.Grocery;
import com.grocerybooking.GroceryBooking.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface GroceryRepository extends JpaRepository<Grocery,Long> {




    List<Grocery> findGroceriesBySalesStatus(boolean salesStatus);


}
