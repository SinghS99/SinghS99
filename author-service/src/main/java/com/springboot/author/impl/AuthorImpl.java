package com.springboot.author.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.author.entities.Author;
import com.springboot.author.exception.ResourceNotFoundException;
import com.springboot.author.repository.AuthorRepo;
import com.springboot.author.services.AuthorService;

@Service
public class AuthorImpl implements AuthorService {
	
	@Autowired
	AuthorRepo authorrepo;
//	@Autowired
//	private ModelMapper modelmapper;


	@Override
	public Author createAuthor(Author author) {
		// TODO Auto-generated method stub
		//Book book=this.BookDtotoBook(bookdto);
		Author savedbook=this.authorrepo.save(author);
		return (savedbook);
	}

	@Override
	public Author updateAuthor(Author author,Integer authorid) {
		// TODO Auto-generated method stub
		Author oldauthor=null;
		Optional<Author>optional=this.authorrepo.findById(authorid);
	 if(optional.isPresent()) 
	        {
		 oldauthor=optional.get();
		 oldauthor.setAuthorid(authorid);
		 oldauthor.setName(author.getName());
		 oldauthor.setEmail(author.getEmail());
		 
				authorrepo.save(oldauthor);
	}else {
		return new Author();
	}
	return oldauthor;
}



	@Override
	public Author getAuthorById(Integer authorid) {
		return  this.authorrepo.findById(authorid).
                orElseThrow(()->new ResourceNotFoundException("Author","authorid",authorid));
	
	}

	@Override
	public List<Author> getAllAuthor() {
		List<Author> authors=this.authorrepo.findAll();
		return authors;
	}

	@Override
	public void deleteAuthor(Integer authorid) {
		Optional<Author> author=this.authorrepo.findById(authorid);
		if(author.isPresent())
		{
			Author Atb = author.get();
			this.authorrepo.delete(Atb);
		}else {

		 throw new ResourceNotFoundException("Author", "authorid", authorid);
		
	}
	}
}
	
//	public AuthorDto  AuthortoAuthorDto(Author author) {
//		AuthorDto authordto=this.modelmapper.map(author,AuthorDto.class);
//		return authordto;
//	}
//	
//	public Author  AuthorDtotoAuthor(AuthorDto authordto) {
//		Author author=this.modelmapper.map(authordto,Author.class);
//		return author;
//	}


