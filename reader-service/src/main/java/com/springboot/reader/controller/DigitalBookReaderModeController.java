package com.springboot.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.reader.entities.Payment;
import com.springboot.reader.model.BookRequest;
import com.springboot.reader.model.BookResponse;
import com.springboot.reader.model.PaymentModel;
import com.springboot.reader.services.DigitalBookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/reader")
public class DigitalBookReaderModeController {
    @Autowired
    DigitalBookService userService;

    @GetMapping("/search")
    public List<BookResponse> searchBook(@RequestParam String category, @RequestParam String author, @RequestParam Long price, @RequestParam String publisher) {
        return userService.getBookDetails(category, author, price, publisher);
    }

    @PostMapping("/buy")
    public String buyBook(@RequestBody BookRequest bookRequest){
        Payment payment = userService.buyBook(bookRequest);
        return "Reader purchased book successfully. Payment Id:"+payment.getPaymentId();
    }

    @GetMapping("/{id}/books")
    public List<PaymentModel> readPaymentDetails(@PathVariable Integer id){
        return userService.getPaymentDetails(id);
    }

    @GetMapping("/books/{bookId}")
    public String readContent(@PathVariable Integer bookId){
        return userService.readContent(bookId);
    }

    @GetMapping("/books")
    public PaymentModel getPaymentById(@RequestParam Long paymentId){
        return userService.getPaymentDetailsById(paymentId);
    }
}
