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

import com.bookmanager.model.Book;
import com.bookmanager.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	//find all books api
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks()
	{
		return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
	}
	
	//find book by id
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId")Integer bookId)
	{
		return new ResponseEntity<>(bookService.getBook(bookId),HttpStatus.OK);
	}
	
	//add book
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book bookRequest)
	{
		return new ResponseEntity<>(bookService.addBook(bookRequest),HttpStatus.OK);
	}
	
	//update book
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId")Integer bookId,@Validated @RequestBody Book bookRequest)
	{
		return new ResponseEntity<>(bookService.updateBook(bookId, bookRequest),HttpStatus.OK);
	}
	
	//delete book by id
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId")Integer bookId)
	{
		bookService.deleteBook(bookId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
