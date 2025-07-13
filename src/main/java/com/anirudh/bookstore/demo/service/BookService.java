package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dto.BookResponse;
import com.anirudh.bookstore.demo.dto.ReviewRequest;
import com.anirudh.bookstore.demo.entity.Book;

import java.util.List;

public interface BookService {
//    List<Book> listAllBooks();
//    Book findBookById(int id);
    Book findBookByName(String title);
    Book saveBook(Book book);
    void deleteBookById(int id);
    public void addReviewToBook(int bookId, ReviewRequest reviewRequest);
    public List<BookResponse> listAllBooks();
    public BookResponse findBookById(int id);
}