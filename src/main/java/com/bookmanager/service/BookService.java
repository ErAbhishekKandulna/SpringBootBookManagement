package com.bookmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.exception.ResourceNotFoundException;
import com.bookmanager.model.Book;
import com.bookmanager.repository.BookRepository;

@Service
public class BookService 
{
	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}
	
	//find book by id
	public Book getBook(Integer bookId)
	{
		return bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book","ID",bookId));
	}
	
	//add book
	public Book addBook(Book bookRequest)
	{
		return bookRepository.save(bookRequest);
	}
	
	
	//update book
	public Book updateBook(Integer bookId,Book bookRequest)
	{
		return bookRepository.findById(bookId).map(book -> {
			book.setName(bookRequest.getName());
			book.setAuthor(bookRequest.getAuthor());
			book.setIsbn(bookRequest.getIsbn());
			book.setLanguage(bookRequest.getLanguage());
			book.setLength(bookRequest.getLength());
			book.setPublisher(bookRequest.getPublisher());
			book.setWeight(bookRequest.getWeight());
			book.setBookCategory(bookRequest.getBookCategory());
			
			return bookRepository.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("Mission","id",bookId));
	}
	
	//delete book
	public Boolean deleteBook(Integer bookId)
	{
		return bookRepository.findById(bookId).map(book -> {
			bookRepository.delete(book);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException("Book","id",bookId));
	}
	
}
