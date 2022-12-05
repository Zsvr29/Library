package com.example.Library.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>{

	boolean existsByName(String name);
}
