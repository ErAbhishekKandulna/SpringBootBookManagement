package com.bookmanager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmanager.model.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

}
