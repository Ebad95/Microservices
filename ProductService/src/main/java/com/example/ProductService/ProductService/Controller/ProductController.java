package com.example.ProductService.ProductService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController{

    @GetMapping("/{id}")
    String getProduct(@PathVariable("id") int id){
        return "Product Fetched with id:"+id;
    }
}