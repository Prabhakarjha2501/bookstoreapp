package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.MyBooks;

@Repository
public interface MyBookRespository extends JpaRepository<MyBooks, Integer>{

	
}
