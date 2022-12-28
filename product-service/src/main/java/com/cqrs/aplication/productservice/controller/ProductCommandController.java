package com.cqrs.aplication.productservice.controller;

import com.cqrs.aplication.productservice.command.CreateProductCommand;
import com.cqrs.aplication.productservice.model.ProductModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductCommandController {

    //[START] Setup CommandGateway
    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }
    //[END] Setup CommandGateway

    @PostMapping("/createProduct")
    public String createProduct(@RequestBody ProductModel productModel){

        String result;
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
            .price(productModel.getPrice())
            .quantity(productModel.getQuantity())
            .title(productModel.getTitle())
            .productId(UUID.randomUUID().toString()).build();

        result = commandGateway.sendAndWait(createProductCommand);
        return result;
    }

}
