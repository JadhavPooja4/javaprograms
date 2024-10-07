package com.algorithum.booksapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algorithum.booksapplication.Repository.BookRepo;
import com.algorithum.booksapplication.entity.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepo bookRpo;
	
	List<Book> list;
	
	public BookServiceImpl() {
//		list =new ArrayList<Book>();
//		list.add(new Book(1,"Java","James Gosling"));
//		list.add(new Book(2,"Web Technology","Tim Berners-Lee"));
	}

	public Book getBook(int bookId) {
		Book b=new Book();
		b.setBookId(bookId);
		return b;
	}

	@Override
	public List<Book> getBooks() {
		
		List<Book>data =bookRpo.findAll();
		
		return data;
	}
	
	

	public String updateService(int bookId,String bookName,String bookAuthor){
		Book book=new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		bookRpo.save(book);
		return "Successfully updated";

		
	   }
	
	
	public String deleteService(int bookId){
		bookRpo.deleteById(bookId);
		return "Data Deleted"; 
	   }

	

	

	

	

	  


	

}
