package com.springboot.reader.services;

import java.util.List;

import com.springboot.reader.entities.Reader;

public interface ReaderService {

	Reader createReader(Reader reader);
	Reader updateReader(Reader reader,Integer readerid);
    Reader  getReaderById(Integer readerid);
   List<Reader> getAllReader();
   void deleteReader(Integer readerid);
}
