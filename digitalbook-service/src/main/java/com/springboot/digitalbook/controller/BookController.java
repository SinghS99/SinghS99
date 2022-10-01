package com.springboot.digitalbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.digitalbook.payloads.ApiResponse;
import com.springboot.digitalbook.payloads.BookDto;
import com.springboot.digitalbook.services.BookService;

@RestController
@RequestMapping("/api/v1/digitalbook")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookdto){
		BookDto createBookDto=this.bookService.createBook(bookdto);
		return new ResponseEntity<>(createBookDto,HttpStatus.CREATED);	
	}
	@PutMapping("/{bookid}")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookdto,@PathVariable ("bookid")Integer bid){
		BookDto updatedBookDto=this.bookService.updateBook(bookdto, bid);
		return ResponseEntity.ok(updatedBookDto);
	}
	@GetMapping("/")
	public ResponseEntity<List<BookDto>> getAllBooks(){
		return ResponseEntity.ok(this.bookService.getAllBook());
	}
	
   @GetMapping("/{bookid}")
	public ResponseEntity<BookDto> getSingleBook(@PathVariable int bookid){
		return ResponseEntity.ok(this.bookService.getBookDtoById(bookid));
	}
   
   @DeleteMapping("/{bookid}")
   public ResponseEntity<ApiResponse> deleteBook(@PathVariable ("bookid") int bookid){
	   this.bookService.deleteBook(bookid);
	   return new ResponseEntity<ApiResponse>(new ApiResponse("Book Deleted Succesfully",true),HttpStatus.OK);
			   
   }
   
}
