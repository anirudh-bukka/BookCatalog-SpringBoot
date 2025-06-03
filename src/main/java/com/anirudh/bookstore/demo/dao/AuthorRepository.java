package com.anirudh.bookstore.demo.dao;

import com.anirudh.bookstore.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
