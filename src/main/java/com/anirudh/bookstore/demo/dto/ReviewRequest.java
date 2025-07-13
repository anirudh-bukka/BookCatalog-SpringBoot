package com.anirudh.bookstore.demo.dto;

import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.entity.Review;

public class ReviewRequest {
    private Book book;
    private Reader reader;
    private String review;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}