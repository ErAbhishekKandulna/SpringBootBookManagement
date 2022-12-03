package com.bookmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.exception.ResourceNotFoundException;
import com.bookmanager.model.BookCategory;
import com.bookmanager.repository.BookCategoryRepository;

@Service
public class BookCategoryService 
{
	@Autowired
	private BookCategoryRepository bookCategoryRepository;
	
	//get all category
	public List<BookCategory> getAllBookCategories()
	{
		return bookCategoryRepository.findAll();
	}
	
	//get book category by id
	public BookCategory getBookCategoryById(int categoryId)
	{
		return bookCategoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("bookCategory", "ID", categoryId));
	}
	
	//add book category
	public BookCategory addBookCategory(BookCategory bookCategoryRequest)
	{
		return bookCategoryRepository.save(bookCategoryRequest);
	}
	
	//update book category
	public BookCategory updateBookCategory(Integer bookCategoryId,BookCategory bookCategoryRequest)
	{
		return bookCategoryRepository.findById(bookCategoryId).map(bookCategory -> {
			bookCategory.setName(bookCategoryRequest.getName());
			return bookCategoryRepository.save(bookCategory);
		}).orElseThrow(() -> new ResourceNotFoundException("Mission","id",bookCategoryId));
	}
	
	//delete book category
	public Boolean deleteBookCatgeory(Integer bookCategoryId)
	{
		return bookCategoryRepository.findById(bookCategoryId).map(bookCategory -> {
			bookCategoryRepository.delete(bookCategory);
			return true;
		}).orElseThrow(()-> new ResourceNotFoundException("BookCategory","id",bookCategoryId));
	}
	
	
}
