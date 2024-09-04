package com.ffutagawa.PurchaseOrder.controllers;

import com.ffutagawa.PurchaseOrder.entities.Order;
import com.ffutagawa.PurchaseOrder.services.OrderService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById (@PathVariable Long id){
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);

    }


}
