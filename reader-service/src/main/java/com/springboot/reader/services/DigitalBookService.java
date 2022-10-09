package com.springboot.reader.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reader.entities.Book;
import com.springboot.reader.entities.Payment;
import com.springboot.reader.entities.User;
import com.springboot.reader.model.BookRequest;
import com.springboot.reader.model.BookResponse;
import com.springboot.reader.model.PaymentModel;
import com.springboot.reader.repository.DigitalBookRepository;
import com.springboot.reader.repository.PaymentRepository;

@Service
public class DigitalBookService {

    @Autowired
    DigitalBookRepository bookRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public List<BookResponse> getBookDetails(String category, String author, Long price, String publisher) {
        List<Book> bookList = bookRepository.getBookDetails(category,author,price,publisher);
        List<BookResponse> bookResponseList = new ArrayList<>();
        bookList.forEach(book ->
              bookResponseList.add(new BookResponse(book.getTitle(),book.getPublisher(),book.getReleaseDate(),book.getCategory(),
                                book.getPrice(),book.getUser().getUsername(),book.getContent(),book.getActive()))
                );
        return bookResponseList;
    }

//    public Book createBook(BookRequest request, Integer authorId) {
//        User user = new User();
//        user.setId(authorId);
//        Book book = new Book(request.getResponse().getTitle(),request.getResponse().getPublisher(),request.getResponse().getReleaseDate(),request.getResponse().getCategory(),
//                request.getResponse().getPrice(),request.getResponse().getActive(),user,request.getResponse().getContent());
//        return bookRepository.save(book);
//    }
//
//    public BookResponse updateBookDetails(BookRequest request,Integer authorId,Integer bookId) {
//        User user = new User();
//        user.setId(authorId);
//        Book book = new Book(request.getResponse().getTitle(),request.getResponse().getPublisher(),request.getResponse().getReleaseDate(),request.getResponse().getCategory(),
//                request.getResponse().getPrice(),request.getResponse().getActive(),user,request.getResponse().getContent());
//        book.setBookId(bookId);
//        bookRepository.save(book);
//        return request.getResponse();
//    }

    public Payment buyBook(BookRequest request){
        Book book = new Book();
        book.setBookId(request.getBookId());
        User user = new User();
        user.setId(request.getUserId());
        Payment payment = new Payment(new Date(),book,user);
        return paymentRepository.save(payment);
    }

    public List<PaymentModel> getPaymentDetails(Integer id){
        List<Payment> paymentList = paymentRepository.findByUserUserId(id);
        List<PaymentModel> paymentModels = new ArrayList<>();
        paymentList.forEach(payment ->
                        paymentModels.add(new PaymentModel(payment.getPaymentId(),payment.getPaymentDate(),payment.getUser().getUsername(),payment.getBook().getBookId()))
                );
        return paymentModels;
    }

    public String readContent(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return book.get().getContent();
    }

    public PaymentModel getPaymentDetailsById(Long paymentId){
        PaymentModel paymentModel = new PaymentModel();
         Optional<Payment> payment = paymentRepository.findById(paymentId);
         paymentModel.setBookId(payment.get().getBook().getBookId());
         paymentModel.setPaymentDate(payment.get().getPaymentDate());
         paymentModel.setPaymentId(payment.get().getPaymentId());
         paymentModel.setReaderName(payment.get().getUser().getUsername());
         return paymentModel;
    }

}
