package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.entity.Review;

import java.util.List;

public interface ReaderService {
    List<Reader> listAllReaders();
    List<Reader> listAllReadersByBookId(int bookId);
    Reader findReaderById(int id);
    Reader saveReader(Reader reader);
    void deleteReaderById(int id);
}
