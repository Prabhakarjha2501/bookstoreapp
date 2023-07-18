package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.MyBooks;
import com.bookstore.repository.MyBookRespository;

@Service
public class MyBookService {
    
	@Autowired
	private MyBookRespository Mb;
	
	public void saveMyBooks(MyBooks b) {
		Mb.save(b);
	}
	public List<MyBooks> getAll(){
		return Mb.findAll();
	}
	public void deleteById(int id) {
		Mb.deleteById(id);
	}
}
