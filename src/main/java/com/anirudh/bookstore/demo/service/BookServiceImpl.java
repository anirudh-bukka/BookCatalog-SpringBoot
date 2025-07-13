package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.BookRepository;
import com.anirudh.bookstore.demo.dao.ReviewRepository;
import com.anirudh.bookstore.demo.dto.BookResponse;
import com.anirudh.bookstore.demo.dto.ReviewRequest;
import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

//    public BookServiceImpl() {}

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

//    @Override
//    public List<Book> listAllBooks() {
//        return bookRepository.findAll();
//    }
//
//    @Override
//    public Book findBookById(int id) {
//        Optional<Book> tempBook = bookRepository.findById(id);
//        Book book = null;
//        if(tempBook.isPresent())
//            book = tempBook.get();
//        else
//            throw new RuntimeException("Book with id: " + id + " not found");
//
//        return book;
//    }

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

    @Override
    @Transactional
    public void addReviewToBook(int bookId, ReviewRequest reviewRequest) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book with id: " + bookId + " not found."));

        Review review = new Review();
        review.setReview(reviewRequest.getReview());
        review.setBook(book);

        reviewRepository.save(review);
    }

//    ========================================================

    @Override
    public List<BookResponse> listAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public BookResponse findBookById(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id: " + id + " not found."));

        return mapToDTO(book);
    }

    private BookResponse mapToDTO(Book book) {
        BookResponse dto = new BookResponse();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setPrice(book.getPrice());
        dto.setGenre(book.getGenre());
        dto.setQuantity(book.getQuantity());
        dto.setReviews(book.getReviews().stream()
                .map(review -> review.getReview()) // Extract only the review text
                .collect(Collectors.toList()));
        return dto;
    }
}