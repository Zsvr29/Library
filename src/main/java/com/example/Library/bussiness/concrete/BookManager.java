package com.example.Library.bussiness.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.Library.DataAccess.abstracts.BookRepository;
import com.example.Library.bussiness.abstracts.BookService;
import com.example.Library.bussiness.request.book.CreateBookRequest;
import com.example.Library.bussiness.request.book.DeleteRequest;
import com.example.Library.bussiness.request.book.UpdateRequest;
import com.example.Library.bussiness.response.GetBookResponse;
import com.example.Library.entities.Book;

public class BookManager  implements BookService{

	
  private BookRepository bookRepository;
	public BookManager(BookRepository bookRepository) {
	
	this.bookRepository = bookRepository;
}

	@Override
	public List<GetBookResponse> getAll() {
		
		List<Book> books= this.bookRepository.findAll();
		List<GetBookResponse> bookResponses= new ArrayList<>();
		for(Book book: books) {
			GetBookResponse bookResponse= new GetBookResponse();
			bookResponse.setId(book.getId());
			bookResponse.setName(book.getName());
			bookResponses.add(bookResponse);
			
		}
		return bookResponses;
	}

	@Override
	public void add(CreateBookRequest createBookRequest) {
		Book book= new Book();
		book.setName(createBookRequest.getName());
		this.bookRepository.save(book);
		
	}

	@Override
	public void delete(DeleteRequest deleteRequest, int id) {
		this.bookRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateRequest updateRquest, int id) {
		Book book= this.bookRepository.findAll().get(id);
		if(Objects.isNull(book)) {
			throw new RuntimeException("hata");
		}
		book.setId(updateRquest.getId());
		this.bookRepository.save(book);
		
	}

	@Override
	public GetBookResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int id) {
		
		 Book books=this.bookRepository.findById(id).get();
		 if(Objects.isNull(books)) {
			 throw new RuntimeException("hata");
		 }
		
		return books;
	}
	

}
