package com.example.Library.bussiness.abstracts;

import java.util.List;

import com.example.Library.bussiness.request.book.CreateBookRequest;
import com.example.Library.bussiness.request.book.DeleteRequest;
import com.example.Library.bussiness.request.book.UpdateRequest;
import com.example.Library.bussiness.response.GetBookResponse;
import com.example.Library.entities.Book;

public interface BookService {
	
	List<GetBookResponse> getAll();
	void add(CreateBookRequest createBookRequest);
	void delete(DeleteRequest deleteRequest,int id);
	void update(UpdateRequest updateRquest,int id);
	GetBookResponse getById(int id);
	
	Book getBookById(int id);
	
	

}
