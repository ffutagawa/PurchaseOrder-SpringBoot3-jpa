package com.ffutagawa.PurchaseOrder.controllers;

import com.ffutagawa.PurchaseOrder.entities.Category;
import com.ffutagawa.PurchaseOrder.entities.Product;
import com.ffutagawa.PurchaseOrder.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findall(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findbyid(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
