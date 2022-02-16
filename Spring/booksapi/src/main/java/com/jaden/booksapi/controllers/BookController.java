package com.jaden.booksapi.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaden.booksapi.models.Book;

import com.jaden.booksapi.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService){
        this.bookService = bookService;
    }
	
	@RequestMapping("/books")
    public String index(Model model) {
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		return "index.jsp";
    }
	
	@RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}