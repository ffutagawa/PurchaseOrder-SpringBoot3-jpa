package com.ffutagawa.PurchaseOrder.repositories;

import com.ffutagawa.PurchaseOrder.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
