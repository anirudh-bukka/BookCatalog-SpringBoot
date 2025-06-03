package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.AuthorRepository;
import com.anirudh.bookstore.demo.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl() {}

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(int id) {
        Optional<Author> tempAuthor = authorRepository.findById(id);

        Author author = null;
        if(tempAuthor.isPresent())
            author = tempAuthor.get();
        else
            throw new RuntimeException("Author with id: " + id + " not found.");

        return author;
    }

    @Override
    @Transactional
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }
}
