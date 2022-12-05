package com.example.Library.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
