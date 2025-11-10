package com.example.OrderService.OrderService.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ProductService", url="http://localhost:8082")
public interface ProductClient {
    
    @GetMapping("/products/{id}")
    String getProductById(@PathVariable("id") int id);

}
