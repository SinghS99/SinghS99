package Com.Book.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.Book.Entity.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	//BookEntity findByName(String name);
	
	//BookEntity updateBook(BookEntity book,
            //int book_Id );

	

	

}
