package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.MyBookService;

@RestController
public class MyBooksController {

	@Autowired
	private MyBookService mbs;
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id")int id) {
		mbs.deleteById(id);
		
		return "redirect:/my_books";
	}
	
}
