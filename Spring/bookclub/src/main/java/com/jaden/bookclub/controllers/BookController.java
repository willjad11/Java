package com.jaden.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaden.bookclub.models.Book;
import com.jaden.bookclub.repositories.UserRepository;
import com.jaden.bookclub.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/books")
    public String books(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
		model.addAttribute("userName", userRepository.findById((Long) session.getAttribute("userId")).get().getUserName());
		model.addAttribute("borrowList", userRepository.findById((Long) session.getAttribute("userId")).get().getBorrowedBooks());
		model.addAttribute("bookList", bookService.allBooks());
		return "/books/books.jsp";
    }
	
	@GetMapping("/books/new")
    public String newbook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
		model.addAttribute("userId", (Long) session.getAttribute("userId"));
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		return "/books/newBook.jsp";
    }
	
    @PostMapping("/books/create")
    public String createbook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
        if (result.hasErrors()) {
            return "/books/newBook.jsp";
        }
        else {
        	bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
    	bookService.deleteBook(id);
        return "redirect:/books";
    }
	
	@RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        model.addAttribute("userId", (Long) session.getAttribute("userId"));
        return "/books/bookDetail.jsp";
    }
	
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/editBook.jsp";
    }
    
    @PutMapping(value="/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		}
        if (result.hasErrors()) {
            return "/books/editBook.jsp";
        } else {
        	bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
}