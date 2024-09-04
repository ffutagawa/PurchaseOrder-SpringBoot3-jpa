package com.ffutagawa.PurchaseOrder.services;

import com.ffutagawa.PurchaseOrder.entities.Order;
import com.ffutagawa.PurchaseOrder.entities.User;
import com.ffutagawa.PurchaseOrder.repositories.OrderRepository;
import com.ffutagawa.PurchaseOrder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
