package com.cqrs.aplication.productservice.eventhandler;

import com.cqrs.aplication.productservice.entity.ProductLookupEntity;
import com.cqrs.aplication.productservice.events.ProductCreatedEvent;
import com.cqrs.aplication.productservice.repository.ProductLookupRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.springframework.stereotype.Component;


@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {
	
	private final ProductLookupRepository productLookupRepository;
	
	public ProductLookupEventsHandler(ProductLookupRepository productLookupRepository) {
		this.productLookupRepository = productLookupRepository;
	}

	@EventHandler
	public void on(ProductCreatedEvent event) {
		
		ProductLookupEntity productLookupEntity = new ProductLookupEntity(event.getProductId(),
				event.getTitle());
		
		productLookupRepository.save(productLookupEntity);
		
	}
	
	@ResetHandler
	public void reset() {
		productLookupRepository.deleteAll();
	}
	
}
