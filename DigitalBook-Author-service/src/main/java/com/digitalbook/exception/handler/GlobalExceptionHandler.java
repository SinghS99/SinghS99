package com.digitalbook.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.digitalbook.exception.AuthorServiceException;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleAllException(Exception e,WebRequest req) {
//		return ResponseEntity.ok(new ErrorResponse(e.getMessage(), e.getClass().toString()));
//	}
}
