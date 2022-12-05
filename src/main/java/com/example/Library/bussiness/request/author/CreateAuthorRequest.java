package com.example.Library.bussiness.request.author;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorRequest {
	
        private String firstName;
        private List<Integer> bookId; //Yazara eklenmek ısteyen kitapların ıd lerını aldık.
	
}
