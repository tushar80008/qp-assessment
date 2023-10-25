package com.grocerybooking.GroceryBooking.controller;

import com.grocerybooking.GroceryBooking.model.Grocery;
import com.grocerybooking.GroceryBooking.model.Orders;
import com.grocerybooking.GroceryBooking.repository.GroceryRepository;
import com.grocerybooking.GroceryBooking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/service/")
public class UserAPIController {

    @Autowired
    private GroceryRepository groceryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders/")
    public List<Grocery> getGroceries(){
        return groceryRepository.findGroceriesBySalesStatus(true);
    }

    @PostMapping("/orders/")
    public ResponseEntity<Map<String, Boolean>> bookOrders(@RequestBody List<Orders> orders){
       for (Orders order:orders){
           Grocery grocery=groceryRepository.findById(order.getGrocery().getId()).get();
           order.setGrocery(grocery);
           orderRepository.save(order);
       }

        Map<String,Boolean> response=new HashMap<>();
        response.put("booked",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
