package com.example.Library.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Kitap")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Book {

	// Teknolojı gıbı dusun.
	//bır kıtabın bır tane yazarı olur. 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="Basım yılı")
	private int yearOfpublication;
	
	@OneToOne
	private Author author;
	
	
	
}
