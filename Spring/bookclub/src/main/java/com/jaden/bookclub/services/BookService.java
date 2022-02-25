package com.jaden.bookclub.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaden.bookclub.models.Book;
import com.jaden.bookclub.repositories.BookRepository;

@Service
public class BookService {
 
	@Autowired
    private BookRepository bookRepository;

	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
	    	return optionalBook.get();
	    }
		else {
	    	return null;
	    }
	}
	
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
	    }
	}
	
	public Book updateBook(@Valid Book book) {
		Optional<Book> optionalBook = bookRepository.findById(book.getId());
		if(optionalBook.isPresent()) {
	    	Book newBook = optionalBook.get();
	    	newBook.setTitle(book.getTitle());
	    	newBook.setBookAuthor(book.getBookAuthor());
	    	newBook.setThoughts(book.getThoughts());
	    	newBook.setBorrower(book.getBorrower());
	    	return bookRepository.save(newBook);
	    }
		else {
	    	return null;
	    }
	}
	
}

