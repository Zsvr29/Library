package com.example.Library.bussiness.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorListResponse {

	private int id;
	private String name;
	
	private List<BookListResponse> bookListResponses; // bir tane yazarda birden fazla kitap olabilir diye istedik.
	
}
