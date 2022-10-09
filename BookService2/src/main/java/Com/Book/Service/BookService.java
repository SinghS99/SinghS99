package Com.Book.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Book.Dao.BookRepo;
import Com.Book.Entity.Book;
import Com.Book.Exception.NoSuchBookExistsException;

@Service
public class BookService {
	@Autowired
	BookRepo bookRepo;

	public Book createbook(Book book) {
		return bookRepo.save(book);
	}

	public List<Book> savebooks(List<Book> books) {
		return bookRepo.saveAll(books);
	}

	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	public Book getBookById(int book_Id) {
		// return bookRepo.findById(book_Id).orElse(null);

		return bookRepo.findById(book_Id)
				.orElseThrow(() -> new NoSuchBookExistsException("NO BOOK PRESENT WITH ID = " + book_Id));
	}

	public Optional<Book> deleteBook(Book book, int book_Id) {
		book.setBookId(book_Id);
		Optional<Book> existingbook = bookRepo.findById(book.getBookId());
		if (existingbook.isPresent()) {
			bookRepo.deleteById(book_Id);
		} else {

			throw new NoSuchBookExistsException("NO BOOK PRESENT WITH ID = " + book_Id);
		}
		return existingbook;
	}

	public Book updateBook(Book book, int book_Id) {
		// TODO Auto-generated method stub
		book.setBookId(book_Id);
		Book existingbook = bookRepo.findById(book.getBookId())
				.orElseThrow(() -> new NoSuchBookExistsException("NO BOOK PRESENT WITH ID = " + book_Id));
		existingbook.setBookId(book.getBookId());
		existingbook.setCategory(book.getCategory());
		existingbook.setTitle(book.getTitle());
		existingbook.setPublisher(book.getPublisher());
		existingbook.setContent(book.getContent());
		existingbook.setPrice(book.getPrice());
		existingbook.setReleaseDate(book.getReleaseDate());
		existingbook.setActiveFlag(book.getActiveFlag());
		
		return bookRepo.save(existingbook);
	}
//	public BookEntity updateBook(BookEntity book)  {
//		if (bookRepo.existsById(book.getBook_Id())) {
//			
//			return bookRepo.save(book);
//		}else {
//			throw new NoSuchBookExistsException("NO BOOK PRESENT WITH ID = " + book.getBook_Id());
//		}
		

}

