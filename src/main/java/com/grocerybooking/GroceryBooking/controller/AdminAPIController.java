package com.grocerybooking.GroceryBooking.controller;

import com.grocerybooking.GroceryBooking.model.Grocery;
import com.grocerybooking.GroceryBooking.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AdminAPIController {

    @Autowired
    private GroceryRepository groceryRepository;

    @GetMapping("/groceries/")
    public List<Grocery> getGroceries(){
        return groceryRepository.findAll();
    }

    @PostMapping("/groceries/")
    public ResponseEntity<Grocery> addGroceries(@RequestBody Grocery grocery){
        return ResponseEntity.status(HttpStatus.CREATED).body(groceryRepository.save(grocery));
    }

    @PutMapping("/groceries/{id}")
    public ResponseEntity<Grocery> updateGroceries(@RequestBody Grocery updatedGrocery,@PathVariable("id") Long id){
        Grocery grocery=groceryRepository.findById(id).get();

        grocery.setItemName(updatedGrocery.getItemName());
        grocery.setItemPrice(updatedGrocery.getItemPrice());
        grocery.setStock(updatedGrocery.getStock());
        grocery.setSalesStatus(updatedGrocery.getSalesStatus());

        Grocery grocery1=groceryRepository.save(grocery);

        return ResponseEntity.ok(grocery1);
    }

    @DeleteMapping("/groceries/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteGroceries(@PathVariable("id") Long id){

        Grocery grocery=groceryRepository.findById(id).get();

        groceryRepository.delete(grocery);

        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
