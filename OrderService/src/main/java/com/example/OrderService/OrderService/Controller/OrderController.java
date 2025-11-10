package com.example.OrderService.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController{

    @Autowired
    private ProductClient productClient;

    @GetMapping("/{id}")
    ResponseEntity<String> getOrder(@PathVariable("id") int id){
        String product = productClient.getProductById(id);
        System.out.println("Order Sucessfull");
        return ResponseEntity.ok().body(product);
    }
}