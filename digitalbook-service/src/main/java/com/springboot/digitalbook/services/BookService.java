package com.springboot.digitalbook.services;

import java.util.List;

import com.springboot.digitalbook.payloads.BookDto;

public interface BookService {

	BookDto createBook(BookDto bookdto);
	BookDto updateBook(BookDto bookdto,Integer bookid);
    BookDto  getBookDtoById(Integer bookid);
   List<BookDto> getAllBook();
   void deleteBook(Integer bookid);
}
