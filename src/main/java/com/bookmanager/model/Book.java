package com.bookmanager.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "bookCategory")
@EqualsAndHashCode(exclude = "bookCategory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String author;
	@NonNull
	private String language;
	@NonNull
	private String isbn;       //international standard book number
	@NonNull
	private String publisher;
	@NonNull
	private Long length;
	@NonNull
	private Double weight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="book_category_id")
	@NonNull
	private BookCategory bookCategory;
}
