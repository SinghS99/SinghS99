package com.springboot.reader.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reader.entities.Reader;
import com.springboot.reader.exception.ResourceNotFoundException;
import com.springboot.reader.repository.ReaderRepo;
import com.springboot.reader.services.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService {
	
	@Autowired
	ReaderRepo readerrepo;
//	@Autowired
//	private ModelMapper modelmapper;


	@Override
	public Reader createReader(Reader reader) {
		// TODO Auto-generated method stub
		//Book book=this.BookDtotoBook(bookdto);
		Reader savedreader=this.readerrepo.save(reader);
		return (savedreader);
	}

	@Override
	public Reader updateReader(Reader reader,Integer readerid) {
		// TODO Auto-generated method stub
		Reader oldreader=null;
		Optional<Reader>optional=this.readerrepo.findById(readerid);
	 if(optional.isPresent()) 
	        {
		 oldreader=optional.get();
		 oldreader.setReaderid(readerid);
		 oldreader.setName(reader.getName());
		 oldreader.setEmail(reader.getEmail());
		
				readerrepo.save(oldreader);
	}else {
		return new Reader();
	}
	return oldreader;
}



	@Override
	public Reader getReaderById(Integer readerid) {
		return  this.readerrepo.findById(readerid).
                orElseThrow(()->new ResourceNotFoundException("Reader","readerid",readerid));
	
	}

	@Override
	public List<Reader> getAllReader() {
		List<Reader> readers=this.readerrepo.findAll();
		return readers;
	}

	@Override
	public void deleteReader(Integer readerid) {
		Optional<Reader> book=this.readerrepo.findById(readerid);
		if(book.isPresent())
		{
			Reader Rtb = book.get();
			this.readerrepo.delete(Rtb);
		}else {

		 throw new ResourceNotFoundException("Reader", "readerid", readerid);
		
	}
	}
}
