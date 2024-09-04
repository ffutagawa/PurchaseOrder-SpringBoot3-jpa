package com.ffutagawa.PurchaseOrder.repositories;

import com.ffutagawa.PurchaseOrder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
