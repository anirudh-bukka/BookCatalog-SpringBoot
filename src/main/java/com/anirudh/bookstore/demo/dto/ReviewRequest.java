package com.anirudh.bookstore.demo.dto;

import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.entity.Review;

public class ReviewRequest {
    private Book book;
    private Reader reader;
    private Review review;

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

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
