package com.bookmanager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmanager.model.BookCategory;

@Repository
@Transactional
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

}
