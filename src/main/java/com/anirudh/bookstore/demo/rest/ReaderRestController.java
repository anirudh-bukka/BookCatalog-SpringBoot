package com.anirudh.bookstore.demo.rest;

import com.anirudh.bookstore.demo.dao.BookRepository;
import com.anirudh.bookstore.demo.dao.ReaderRepository;
import com.anirudh.bookstore.demo.dto.ReaderRequest;
import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.service.BookService;
import com.anirudh.bookstore.demo.service.ReaderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readersApi")
public class ReaderRestController {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    public ReaderRestController() {}

    @Autowired
    public ReaderRestController(ReaderRepository readerRepository, BookRepository bookRepository) {
        this.readerRepository = readerRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/readers")
    public List<Reader> retrieveAllReaders() {
        return readerRepository.findAll();
    }

    @GetMapping("/readers/{readerId}")
    public Reader retrieveReaderById(@PathVariable int readerId) {
        Optional<Reader> tempReader = readerRepository.findById(readerId);
        Reader reader = null;
        if(tempReader.isPresent())
            reader = tempReader.get();
        else
            throw new RuntimeException("Reader with id " + readerId + " not found");

        return reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @PostMapping("/readers")
    @Transactional
    public List<Reader> addReaders(@RequestBody List<ReaderRequest> readerRequests) {
        List<Reader> readers = new ArrayList<>();
        for (ReaderRequest readerRequest : readerRequests) {
            if (readerRequest.getReader() == null) {
                throw new RuntimeException("Reader information is missing");
            }

            Reader reader = new Reader();
            reader.setFirstName(readerRequest.getReader().getFirstName());
            reader.setLastName(readerRequest.getReader().getLastName());
            reader.setEmail(readerRequest.getReader().getEmail());

            readers.add(readerService.saveReader(reader));
        }
        return readers;
    }

    Reader reader = new Reader();
    List<Reader> readers;
    Book book = new Book();
    @PutMapping("readers/{readerId}/books")
    @Transactional
    public List<Book> addBooksToReader(@PathVariable int readerId, @RequestBody List<Integer> bookIds) {
        Optional<Reader> optionalReader = readerRepository.findById(readerId);
        if (optionalReader.isEmpty()) {
            throw new RuntimeException("Reader with id: " + readerId + " does not exist.");
        }

        Reader reader = optionalReader.get();
        List<Book> validBooks = new ArrayList<>();

        for (Integer bookId : bookIds) {
            Optional<Book> optionalBook = bookRepository.findById(bookId);
            if (optionalBook.isEmpty()) {
                throw new RuntimeException("Book with id: " + bookId + " does not exist.");
            }

            Book book = optionalBook.get();
            if (!reader.getBooks().contains(book)) { // Prevent duplicate entries
                reader.getBooks().add(book);
                validBooks.add(book);
            }
        }

        readerRepository.save(reader); // Save the updated reader
        return validBooks;
    }


//  //  ---------------------
//    Reader reader = new Reader();
//    List<Reader> readers;
//    Book book = new Book();

//    @PutMapping("readers/{readerId}/books")
//    @Transactional
//    public List<Book> addBooksToReader(@PathVariable int readerId, @RequestBody List<Integer> bookIds) {
//        Optional<Reader> optionalReader = readerRepository.findById(readerId);
//        if(optionalReader.isPresent())
//            reader = optionalReader.get();
//        else
//            throw new RuntimeException("Reader with id: " + readerId + " does not exist.");
//
//        List<Book> validBooks = new ArrayList<>();
//
//        for(Integer bookId : bookIds) {
//            Optional<Book> optionalBook = bookRepository.findById(bookId);
//            if(!optionalBook.isPresent())
//                continue;
//
//            Book existingBook = optionalBook.get();
//
//            if(existingBook.getQuantity() > 0) {
//                existingBook.setQuantity(existingBook.getQuantity() - 1);
//                existingBook.getReaders().add(reader);
//                validBooks.add(existingBook);
//                bookRepository.save(existingBook);
//            }
//        }
//
//        reader.setBooks(validBooks);
//        readerRepository.save(reader);
//
//        return validBooks;
//
// //   ---------------------

    @DeleteMapping("/readers/{readerId}")
    @Transactional
    public String deleteReaderById(@PathVariable int readerId) {
        readerRepository.deleteById(readerId);
        return "Deleted reader with id: " + readerId;
    }
}
