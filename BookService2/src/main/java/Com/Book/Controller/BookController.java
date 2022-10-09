package Com.Book.Controller;

import java.util.List;
import java.util.Optional;

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

import Com.Book.Entity.Book;
import Com.Book.Service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController {
	  @Autowired
	  private BookService bookservice;

	    @PostMapping("/createbook")
	    public Book addBook(@RequestBody Book book) {
	        return bookservice.createbook(book);
	    }

	    @PostMapping("/createlistBooks")
	    public List<Book> addBooks(@RequestBody List<Book> books) {
	        return bookservice.savebooks(books);
	    }

	    @GetMapping("/getbooks")
	    public ResponseEntity<List<Book>> findAllBooks() {
	    	
	        List<Book> list=bookservice.getBooks();
	        if(list.size()<=0) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.of(Optional.of(list));
	    }

	    @GetMapping("/bookById/{book_Id}")
	    public ResponseEntity<Book> findBookById(@PathVariable int book_Id) {
	    	
	    	Book book= bookservice.getBookById(book_Id);
	        if(book==null) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     
	        }
	        return ResponseEntity.of(Optional.of(book));
	    }

	  
	    @PutMapping("/update")
	    public Book updateBook(@RequestBody Book book)
	    {
	        return bookservice.updateBook(book, book.getBookId());
	    }
	    
	    @DeleteMapping("/delete/{book_Id}")
	    public Optional<Book> deleteBook(@RequestBody Book book,@PathVariable("book_Id") int book_Id) {
	        return bookservice.deleteBook(book, book_Id);
	    }
	    
	 

}
