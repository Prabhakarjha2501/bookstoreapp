package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired	
	private BookRepository br;
	public void save (Book b) {
		br.save(b);
	}
	
	public List<Book> getAllbook(){
		return br.findAll();
	}
	public Book getbookById(int id) {
		return br.findById(id).get();
	}
	public void deleteById(int id) {
	    	br.deleteById(id);
	}
}
