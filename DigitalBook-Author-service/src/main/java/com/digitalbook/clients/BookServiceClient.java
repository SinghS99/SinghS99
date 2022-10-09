package com.digitalbook.clients;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.digitalbook.entities.Book;
import com.digitalbook.models.BookEntity;
import com.digitalbook.models.Show;

import feign.Headers;

@FeignClient(name="BookService2",url="localhost:8081")
public interface BookServiceClient {
	
	@GetMapping("/api/v1/digitalbooks/getbooks")
	List<Show> getBooks();
	
	@PostMapping("/api/v1/digitalbooks/createbook")
	@Headers("Content-Type: application/json")
	Book SaveBook(Book book);
	
	@PutMapping("/api/v1/digitalbooks/update")
    @Headers("Content-Type: application/json")
	Book updateBook(Book book);
	
	
}
