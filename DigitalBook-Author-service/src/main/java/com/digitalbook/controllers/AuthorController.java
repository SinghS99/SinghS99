package com.digitalbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.clients.BookServiceClient;
import com.digitalbook.entities.Author;
import com.digitalbook.entities.Book;
import com.digitalbook.services.AuthorService;

@RestController
@RequestMapping("/api/v1/digitalbooks/authors")
public class AuthorController {

	@Autowired
	private BookServiceClient bookServiceClient;

	@Autowired
	private AuthorService service;

	@GetMapping("/getauthor")
	public ResponseEntity<List<Author>> getAllAuthors() {

		List<Author> list = service.getAllAuthors();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@PostMapping("/signup")
	public Author saveAuthor(@RequestBody Author author) {
		return service.saveAuthor(author);
	}

	@PostMapping("{authorid}/books")
	public Book saveBook(@PathVariable int authorid, @RequestBody Book book) {
		book.setAuthorid(authorid);
		return bookServiceClient.SaveBook(book);

	}

	@PutMapping("{authorid}/books/{bookId}")
	public Book updateBook(@PathVariable int authorid, @PathVariable int bookId, @RequestBody Book book) {
		book.setAuthorid(authorid);
		book.setBookId(bookId);
		return bookServiceClient.updateBook(book);

	}

	/*
	 * @GetMapping("/getBooks") public List<Show> getBooksFromBookService() {
	 * 
	 * return bookServiceClient.getBooks();
	 * 
	 * }
	 */

}
