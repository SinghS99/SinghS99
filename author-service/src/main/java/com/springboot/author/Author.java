package com.springboot.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.springboot.author.impl.AuthorImpl;

@SpringBootApplication
@EnableEurekaClient
public class Author implements CommandLineRunner {

	@Autowired
	AuthorImpl service;
	
	public static void main(String[] args) {
		SpringApplication.run(Author.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.createBook((new Book(1,"Spiderman","Harry","Adenvture"));
		
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
				
	}

}
