package com.ffutagawa.PurchaseOrder.repositories;

import com.ffutagawa.PurchaseOrder.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
