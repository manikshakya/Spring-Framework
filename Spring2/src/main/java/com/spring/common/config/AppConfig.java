package com.spring.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.spring.common.data.repository.CustomerRepository;
import com.spring.common.data.repository.InventoryItemRepository;
import com.spring.common.data.repository.SalesOrderRepository;
import com.spring.common.service.InventoryService;
import com.spring.common.service.OrderService;
import com.spring.common.service.impl.InventoryServiceImpl;
import com.spring.common.service.impl.OrderServiceImpl;

@Configuration
@Import(DataConfig.class)
public class AppConfig {
	
	@Autowired
	private InventoryItemRepository inventoryItemRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Bean
	public OrderService orderService(InventoryService inventoryService, 
									CustomerRepository customerRepository, 
									SalesOrderRepository salesOrderRepository) {
		return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
	}
	
	@Bean
	public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
		return new InventoryServiceImpl(inventoryItemRepository);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = context.getBean(OrderService.class);
		
		System.out.println(orderService==null?"Null":"A OK");

	}

}
