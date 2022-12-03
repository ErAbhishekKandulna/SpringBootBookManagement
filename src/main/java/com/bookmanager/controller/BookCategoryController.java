package com.bookmanager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.model.BookCategory;
import com.bookmanager.service.BookCategoryService;

@RestController
@RequestMapping("/api/bookCategories")
public class BookCategoryController 
{
	@Autowired
	private BookCategoryService bookCategoryService;
	
	//get all book category api
	@GetMapping
	public ResponseEntity<List<BookCategory>> getBookCategories()
	{
		return new ResponseEntity<>(bookCategoryService.getAllBookCategories(),HttpStatus.OK);
	}
	
	//get book category by id api
	@GetMapping("/{bookCategoryId}")
	public ResponseEntity<BookCategory> getBook(@PathVariable("bookCategoryId")Integer bookCategoryId)
	{
		return new ResponseEntity<>(bookCategoryService.getBookCategoryById(bookCategoryId),HttpStatus.OK);
	}
	
	//add book category api
	@PostMapping
	public ResponseEntity<BookCategory> addBookCategory(@RequestBody BookCategory bookCategoryRequest)
	{
		return new ResponseEntity<>(bookCategoryService.addBookCategory(bookCategoryRequest),HttpStatus.OK);
	}
	
	//update book category
	@PutMapping("/{bookCategoryId}")
	public ResponseEntity<BookCategory> updateBookCategory(@PathVariable("bookCategoryId")Integer bookCategoryId,@Validated @RequestBody BookCategory bookCategoryRequest)
	{
		return new ResponseEntity<>(bookCategoryService.updateBookCategory(bookCategoryId,bookCategoryRequest),HttpStatus.OK);
	}
	
	//delete book category
	@DeleteMapping("/{bookCategoryId}")
	public ResponseEntity<Void> deleteBookCategory(@PathVariable("bookCategoryId")Integer bookCategoryId)
	{
		bookCategoryService.deleteBookCatgeory(bookCategoryId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
