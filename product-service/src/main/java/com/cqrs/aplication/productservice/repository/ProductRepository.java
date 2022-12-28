package com.cqrs.aplication.productservice.repository;

import com.cqrs.aplication.productservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
