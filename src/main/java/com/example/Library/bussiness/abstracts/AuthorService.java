package com.example.Library.bussiness.abstracts;

import java.util.List;

import com.example.Library.bussiness.request.author.CreateAuthorRequest;
import com.example.Library.bussiness.request.author.DeleteRequest;
import com.example.Library.bussiness.request.author.UpdateRequest;
import com.example.Library.bussiness.response.GetAuthorResponse;

public interface AuthorService {
	List<GetAuthorResponse> getAll();
	void add(CreateAuthorRequest createAuthorRequest);
	void delete(DeleteRequest deleteRequest,int id);
	void update(UpdateRequest updateRequest,int id);
	GetAuthorResponse getById(int id);
	

}
