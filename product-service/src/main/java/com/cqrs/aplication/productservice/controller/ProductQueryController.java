package com.cqrs.aplication.productservice.controller;

import com.cqrs.aplication.productservice.command.CreateProductCommand;
import com.cqrs.aplication.productservice.model.ProductModel;
import com.cqrs.aplication.productservice.query.FindProductQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/getProduct")
    public List<ProductModel> getProduct(){
        FindProductQuery findProductQuery = new FindProductQuery();
        List<ProductModel> products = queryGateway.query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductModel.class)).join();
        return products;
    }

}
