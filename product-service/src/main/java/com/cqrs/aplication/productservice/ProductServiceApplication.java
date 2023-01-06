package com.cqrs.aplication.productservice;

import com.cqrs.aplication.productservice.interceptors.CreateProductCommandInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.axonframework.commandhandling.CommandBus;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Autowired
	public void registerCreateProductCommandInterceptor(ApplicationContext context,CommandBus commandBus) {
		commandBus.registerDispatchInterceptor(context.getBean(CreateProductCommandInterceptor.class));
	}
}
