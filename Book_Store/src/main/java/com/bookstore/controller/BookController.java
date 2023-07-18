package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.model.Book;
import com.bookstore.model.MyBooks;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookService;

@RestController
public class BookController {

	@Autowired
	private BookService ser;
	@Autowired
	private MyBookService Mser;
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@RequestMapping("/available_book")
	public ModelAndView Avialable_book() {
	       List<Book>list=ser.getAllbook();
	       return new ModelAndView("A_book","book",list);
	}
	@RequestMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		ser.save(b);
		return "redirect:/available_book";
		
	}
	@RequestMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBooks> list=Mser.getAll();
		model.addAttribute("book", list);
		return "myBooks";
		
	}
	@RequestMapping("/mylist/{id}")
	public String getMylist(@PathVariable("id")int id) {
		Book b=ser.getbookById(id);
		MyBooks mb= new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		Mser.saveMyBooks(mb);
		return"redirect:/my_books";
		
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model m) {
		Book be=ser.getbookById(id);
		m.addAttribute("book", be);
		
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		ser.deleteById(id);
		return "redirect:/available_book";
	}
	
}
