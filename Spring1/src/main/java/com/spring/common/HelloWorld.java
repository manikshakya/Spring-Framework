package com.spring.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorld {
	
	@Bean
	public String greeting() {
		return "World.";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);
		
		String word = (String)context.getBean("greeting");
		
		System.out.println("Hello " + word);

	}

}
