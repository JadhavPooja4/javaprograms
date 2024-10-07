package com.algorithum.booksapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.algorithum.booksapplication.entity.Book;

@Service
public interface BookService {
	
	public List<Book> getBooks();

	

	public String updateService(int bookId, String bookName, String bookAuthor);



	public String deleteService(int bookId);

	

	

	

}
