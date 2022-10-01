package com.springboot.digitalbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.springboot.digitalbook.impl.BookServiceImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "DigitalBook", version = "1.0", description = "This is Book App"))

public class DigitalbookApplication implements CommandLineRunner {

	@Autowired
	BookServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(DigitalbookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// service.createBook((new Book(1,"Spiderman","Harry","Adenvture"));

	}
//	@Bean
//	public RestTemplate resttemplate() {
//		return new RestTemplate();
//	}
	

}
