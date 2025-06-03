package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAllAuthors();
    Author findAuthorById(int id);
    Author saveAuthor(Author author);
    void deleteAuthorById(int id);
}
