package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.BookRepository;
import com.anirudh.bookstore.demo.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl() {}

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(int id) {
        Optional<Book> tempBook = bookRepository.findById(id);
        Book book = null;
        if(tempBook.isPresent())
            book = tempBook.get();
        else
            throw new RuntimeException("Book with id: " + id + " not found");

        return book;
    }

    @Override
    public Book findBookByName(String title) {
        return null;
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}
