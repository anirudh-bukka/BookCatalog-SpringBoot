package com.anirudh.bookstore.demo.dto;

import com.anirudh.bookstore.demo.entity.Author;
import com.anirudh.bookstore.demo.entity.AuthorDetail;
import com.anirudh.bookstore.demo.entity.Book;

import java.util.List;

public class AuthorRequest {
    private Author author;
    private AuthorDetail authorDetail;
    private List<Book> books;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public AuthorDetail getAuthorDetail() {
        return authorDetail;
    }

    public void setAuthorDetail(AuthorDetail authorDetail) {
        this.authorDetail = authorDetail;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
