package com.example.Library.bussiness.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.Library.DataAccess.abstracts.AuthorRepository;
import com.example.Library.bussiness.abstracts.AuthorService;
import com.example.Library.bussiness.abstracts.BookService;
import com.example.Library.bussiness.request.author.CreateAuthorRequest;
import com.example.Library.bussiness.request.author.DeleteRequest;
import com.example.Library.bussiness.request.author.UpdateRequest;
import com.example.Library.bussiness.response.GetAuthorResponse;
import com.example.Library.entities.Author;
import com.example.Library.entities.Book;

@Service

public class AuthorManager implements AuthorService{

	private static final String String = null;
	private AuthorRepository authorRepository;
	private BookService bookService;
	
	public AuthorManager(AuthorRepository authorRepository,BookService bookService) {
		
		this.authorRepository = authorRepository;
		this.bookService=bookService;
	}

	@Override
	public List<GetAuthorResponse> getAll() {
		
		List<Author> authors=this.authorRepository.findAll();
		List<GetAuthorResponse> authorResponses= new ArrayList<>();
		for (Author author  :authors ) {
			GetAuthorResponse getAuthorResponse= new GetAuthorResponse();
			getAuthorResponse.setId(author.getId());
			getAuthorResponse.setName(author.getFirstName());
			
		}
		
		return authorResponses;
	}

	@Override
	public void add(CreateAuthorRequest createAuthorRequest) {
	
		control(String);
		Author author= new Author();
		author.setFirstName(createAuthorRequest.getFirstName());
		List<Book> books= new ArrayList<>();
		for(Integer bookId:createAuthorRequest.getBookId()) {
		Book book= this.bookService.getBookById(bookId);
		books.add(book);
		}
		
		author.setBooks(books);
		this.authorRepository.save(author);
	}
	private void control(String name) {
		if(this.authorRepository.existsByName(name)) {
			throw new  RuntimeException("hata");
		}
	}

	@Override
	public void delete(DeleteRequest deleteRequest, int id) {
		this.authorRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateRequest updateRequest, int id) {
		
		Author author= this.authorRepository.findById(id).get();
		List<Book> books=new ArrayList<>();
		if(Objects.isNull(books)) {
			throw new  RuntimeException("hata");
			
		}
		
		author.setBooks(books);
		author.setFirstName(updateRequest.getFirstName());
		authorRepository.save(author);
		
	}

	@Override
	public GetAuthorResponse getById(int id) {
		
		return null;
	}

}
