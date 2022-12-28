package com.cqrs.aplication.productservice.repository;

import com.cqrs.aplication.productservice.entity.ProductEntity;
import com.cqrs.aplication.productservice.entity.ProductLookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLookupRepository extends JpaRepository<ProductLookupEntity, String> {

    ProductLookupEntity findByProductIdOrTitle(String productId, String title);
}
