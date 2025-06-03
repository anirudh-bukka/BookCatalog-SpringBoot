package com.anirudh.bookstore.demo.dto;

import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.entity.Review;

import java.util.List;

public class ReaderRequest {
    private Reader reader;
    private List<Book> books;
    private Book book;
    private Review review;
    private List<Review> reviews;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
