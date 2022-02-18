package com.jaden.booksapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    @PostMapping("/books/create")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
	
	@RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}