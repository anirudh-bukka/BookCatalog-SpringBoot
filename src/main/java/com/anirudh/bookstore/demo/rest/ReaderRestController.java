package com.anirudh.bookstore.demo.rest;

import com.anirudh.bookstore.demo.dao.ReaderRepository;
import com.anirudh.bookstore.demo.dto.ReaderRequest;
import com.anirudh.bookstore.demo.entity.Book;
import com.anirudh.bookstore.demo.entity.Reader;
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

    private ReaderRepository readerRepository;
    private ReaderService readerService;

    public ReaderRestController() {}

    @Autowired
    public ReaderRestController(ReaderRepository readerRepository, ReaderService readerService) {
        this.readerRepository = readerRepository;
        this.readerService = readerService;
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

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

//    @PostMapping("/readers")
//    @Transactional
//    public Reader addReaderWithBooks(@RequestBody ReaderRequest readerRequest) {
//        if (readerRequest.getReader() == null) {
//            throw new RuntimeException("Reader information is missing");
//        }
//
//        System.out.println("Received Reader: " + readerRequest.getReader());
//
//        Reader reader = new Reader();
//        reader.setFirstName(readerRequest.getReader().getFirstName());
//        reader.setLastName(readerRequest.getReader().getLastName());
//        reader.setEmail(readerRequest.getReader().getEmail());
//
//        return readerService.saveReader(reader);
//    }
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

    @PutMapping("/readers/{readerId}/books")
    @Transactional
    public Reader addBooksToReader(@PathVariable int readerId, @RequestBody List<Integer> bookIds) {
        Optional<Reader> optionalReader = readerRepository.findById(readerId);
        if (!optionalReader.isPresent()) {
            throw new RuntimeException("Reader with id " + readerId + " not found");
        }

        Reader reader = optionalReader.get();
        List<Book> books = new ArrayList<>();
        for (int bookId : bookIds) {
            Book book = new Book();
            book.setId(bookId);
            books.add(book);
        }
        reader.setBooks(books);

        return readerRepository.save(reader);
    }

    @DeleteMapping("/readers/{readerId}")
    @Transactional
    public String deleteReaderById(@PathVariable int readerId) {
        readerRepository.deleteById(readerId);
        return "Deleted reader with id: " + readerId;
    }
}
