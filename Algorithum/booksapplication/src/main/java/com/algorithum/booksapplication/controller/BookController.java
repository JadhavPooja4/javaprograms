package com.algorithum.booksapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algorithum.booksapplication.entity.Book;

import com.algorithum.booksapplication.service.BookService;

@RestController
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/welcome")
	public String home() {
		return "Welcome to Book Application";
	}
	
	
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookService.getBooks();
	}
	
	
	
	@PutMapping("/update")
    public String update(@RequestParam int bookId,@RequestParam String bookName,@RequestParam String bookAuthor){
      String str =bookService.updateService(bookId,bookName,bookAuthor);
        return str;
    }
	
	
	@DeleteMapping("/delete")
    public String delete(@RequestParam int bookId){
		String str=bookService.deleteService(bookId);
        return str;
    }

}
