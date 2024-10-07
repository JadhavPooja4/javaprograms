package com.algorithum.booksapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algorithum.booksapplication.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
