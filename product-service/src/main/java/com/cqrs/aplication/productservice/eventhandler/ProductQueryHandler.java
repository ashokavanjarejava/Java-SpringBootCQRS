package com.cqrs.aplication.productservice.eventhandler;

import com.cqrs.aplication.productservice.entity.ProductEntity;
import com.cqrs.aplication.productservice.model.ProductModel;
import com.cqrs.aplication.productservice.query.FindProductQuery;
import com.cqrs.aplication.productservice.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductModel> findProducts(FindProductQuery findProductQuery){
        List<ProductModel> productModelList = new ArrayList<>();
        List<ProductEntity> productList = productRepository.findAll();

        for(ProductEntity pe : productList){
            ProductModel pm = new ProductModel();
            pm.setPrice(pe.getPrice());
            pm.setQuantity(pe.getQuantity());
            pm.setTitle(pe.getTitle());
            productModelList.add(pm);
        }

        return productModelList;
    }

}
