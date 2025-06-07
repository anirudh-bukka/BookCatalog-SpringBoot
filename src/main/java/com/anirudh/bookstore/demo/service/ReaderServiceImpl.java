package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.ReaderRepository;
import com.anirudh.bookstore.demo.entity.Author;
import com.anirudh.bookstore.demo.entity.Reader;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService {

    private ReaderRepository readerRepository;

    public ReaderServiceImpl() {}

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public List<Reader> listAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public List<Reader> listAllReadersByBookId(int bookId) {
        return null;
    }

    @Override
    public Reader findReaderById(int id) {
        Optional<Reader> tempReader = readerRepository.findById(id);

        Reader reader = null;
        if(tempReader.isPresent())
            reader = tempReader.get();
        else
            throw new RuntimeException("Reader with id: " + id + " not found.");

        return reader;
    }

    @Override
    @Transactional
    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    @Transactional
    public void deleteReaderById(int id) {
        readerRepository.deleteById(id);
    }
}
