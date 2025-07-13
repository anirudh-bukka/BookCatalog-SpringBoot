package com.anirudh.bookstore.demo.rest;

import com.anirudh.bookstore.demo.dao.AuthorRepository;
import com.anirudh.bookstore.demo.dto.BookRequest;
import com.anirudh.bookstore.demo.dto.BookResponse;
import com.anirudh.bookstore.demo.dto.ReviewRequest;
import com.anirudh.bookstore.demo.entity.Author;
import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booksApi")
public class BookRestController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookService bookService;

    public BookRestController() {}

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/books")
//    public List<Book> retrieveAllBooks() {
//        return bookService.listAllBooks();
//    }
//
//    @GetMapping("/books/{bookId}")
//    public Book retrieveBookById(@PathVariable int bookId) {
//        return bookService.findBookById(bookId);
//    }
    @GetMapping("/books")
    public List<BookResponse> getAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookResponse getBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    @PostMapping("/books")
    @Transactional
    public Book addBook(@RequestBody BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setGenre(bookRequest.getGenre());
        book.setQuantity(bookRequest.getQuantity());
        book.setAuthor(bookRequest.getAuthor());

        // Fetch the existing author from the database
        Author author = authorRepository.findById(bookRequest.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);

        return bookService.saveBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    @Transactional
    public void removeBookById(@PathVariable int bookId) {
        bookService.deleteBookById(bookId);
    }

    @PostMapping("/books/{id}/reviews")
    @Transactional
    public void addReviewToBook(@PathVariable int id, @RequestBody ReviewRequest reviewRequest) {
        bookService.addReviewToBook(id, reviewRequest);
    }
}