package com.springboot.digitalbook.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.digitalbook.entities.Book;
import com.springboot.digitalbook.exception.ResourceNotFoundException;
import com.springboot.digitalbook.payloads.BookDto;
import com.springboot.digitalbook.repository.BookRepo;
import com.springboot.digitalbook.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepo bookrepo;
	@Autowired
	private ModelMapper modelmapper;
//	@Autowired
//	RestTemplate rest;

	@Override
	public BookDto createBook(BookDto bookdto) {
		// TODO Auto-generated method stub
		Book book=this.BookDtotoBook(bookdto);
		Book savedbook=this.bookrepo.save(book);
		return this.BooktoBookDto(savedbook);
	}

	@Override
	public BookDto updateBook(BookDto bookdto, Integer bookid) {
		// TODO Auto-generated method stub
		Book book=this.bookrepo.findById(bookid).
	                 orElseThrow(()->new ResourceNotFoundException("Book","bookid",bookid));
		return this.BooktoBookDto(book);
	}

	@Override
	public BookDto getBookDtoById(Integer bookid) {
		Book book=this.bookrepo.findById(bookid).
                orElseThrow(()->new ResourceNotFoundException("Book","bookid",bookid));
	return this.BooktoBookDto(book);
	}

	@Override
	public List<BookDto> getAllBook() {
		List<Book> books=this.bookrepo.findAll();
		
		List<BookDto>bookdto=books.stream().
				map(book->this.BooktoBookDto(book)).collect(Collectors.toList());
		
		return bookdto;
	}

	@Override
	public void deleteBook(Integer bookid) {
		Book book=this.bookrepo.findById(bookid).
		orElseThrow(()->new ResourceNotFoundException("Book", "bookid", bookid));
		this.bookrepo.delete(book);
	}
	
	public BookDto  BooktoBookDto(Book book) {
		BookDto bookdto=this.modelmapper.map(book,BookDto.class);
		return bookdto;
	}
	
	public Book  BookDtotoBook(BookDto bookdto) {
		Book book=this.modelmapper.map(bookdto,Book.class);
		return book;
	}

}
