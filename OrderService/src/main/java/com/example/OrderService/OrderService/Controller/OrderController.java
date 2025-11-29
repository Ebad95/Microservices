package com.example.OrderService.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.OrderService.FeignClient.ProductClient;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController{

    @Autowired
    private ProductClient productClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    ResponseEntity<String> getOrder(@PathVariable("id") int id){
        String product = productClient.getProductById(id);
        System.out.println("Order Sucessfull");
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/rest-template/{id}")
    ResponseEntity<String> getOrderByRestTemplate(@PathVariable("id") int id){
        List<ServiceInstance> instances=discoveryClient.getInstances("product-service");
        URI uri = instances.get(0).getUri();
        String response = restTemplate.getForObject(uri+"/products/"+id, String.class);
        return ResponseEntity.ok().body(response);
    }
}