package com.anirudh.bookstore.demo.dao;

import com.anirudh.bookstore.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
