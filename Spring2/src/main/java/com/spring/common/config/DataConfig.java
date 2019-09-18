package com.spring.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.common.data.repository.CustomerRepository;
import com.spring.common.data.repository.InventoryItemRepository;
import com.spring.common.data.repository.SalesOrderRepository;

@Configuration
public class DataConfig {
	
	@Bean
	public InventoryItemRepository inventoryItemRepository() {
		return new InventoryItemRepository();
	}
	
	@Bean
	public CustomerRepository CustomerRepository() { 
		return new CustomerRepository();
	}
	
	@Bean
	public SalesOrderRepository salesOrderRepository() {
		return new SalesOrderRepository();
	}

}
