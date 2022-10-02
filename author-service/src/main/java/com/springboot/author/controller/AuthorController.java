package com.springboot.author.controller;

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
import org.springframework.web.client.RestTemplate;

import com.springboot.author.entities.Author;
import com.springboot.author.payloads.ApiResponse;
import com.springboot.author.services.AuthorService;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
	@Autowired
	AuthorService authorService;
//	@Autowired
//	RestTemplate resttemplate;
	
	@PostMapping("/")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author){
		Author createAuthor=this.authorService.createAuthor(author);
		return new ResponseEntity<>(createAuthor,HttpStatus.CREATED);	
	}
	@PutMapping("/{authorid}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author,@PathVariable ("authorid")Integer aid){
		Author updatedAuthor=this.authorService.updateAuthor(author, aid);
		return ResponseEntity.ok(updatedAuthor);
	}
	@GetMapping("/")
	public ResponseEntity<List<Author>> getAllAuthors(){
		return ResponseEntity.ok(this.authorService.getAllAuthor());
	}
	
   @GetMapping("/{authorid}")
	public ResponseEntity<Author> getSingleAuthor(@PathVariable int authorid){
	  // this.resttemplate.getForObject("http://Book-service:8081", responseType)
		return ResponseEntity.ok(this.authorService.getAuthorById(authorid));
	}
   
   @DeleteMapping("/{authorid}")
   public ResponseEntity<ApiResponse> deleteAuthor(@PathVariable ("authorid") int aid){
	   this.authorService.deleteAuthor(aid);
	   return new ResponseEntity<ApiResponse>(new ApiResponse("Author Deleted Succesfully",true),HttpStatus.OK);
			   
   }
   
}
