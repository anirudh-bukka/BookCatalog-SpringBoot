package com.anirudh.bookstore.demo.dto;

import com.anirudh.bookstore.demo.entity.Author;
import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.entity.Review;

import java.util.List;

public class BookRequest {

    private String title;
    private int price;
    private String genre;
    private int quantity;
    private Author author;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }



//    private Book book;
//    private Author author;
//    private List<Review> reviews;
//    private List<Reader> readers;
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public List<Reader> getReaders() {
//        return readers;
//    }
//
//    public void setReaders(List<Reader> readers) {
//        this.readers = readers;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
}
