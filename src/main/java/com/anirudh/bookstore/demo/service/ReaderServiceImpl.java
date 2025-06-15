package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.ReaderRepository;
import com.anirudh.bookstore.demo.dto.ReaderResponse;
import com.anirudh.bookstore.demo.entity.Reader;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReaderServiceImpl implements ReaderService {

    private ReaderRepository readerRepository;

    public ReaderServiceImpl() {}

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

//    @Override
//    public List<Reader> listAllReaders() {
//        return readerRepository.findAll();
//    }

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

    @Override
    public ReaderResponse getReaderById(int id) {
        Reader reader = readerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader with id: " + id + " not found."));

        // Map Reader entity to ReaderResponse
        ReaderResponse readerResponse = new ReaderResponse();
        readerResponse.setId(reader.getId());
        readerResponse.setFirstName(reader.getFirstName());
        readerResponse.setLastName(reader.getLastName());
        readerResponse.setEmail(reader.getEmail());
        readerResponse.setBooks(reader.getBooks().stream()
                .map(book -> book.getTitle()) // Extract only book titles
                .collect(Collectors.toList()));

        return readerResponse;
    }

    @Override
    public List<ReaderResponse> listAllReaders() {
        List<Reader> readers = readerRepository.findAll();
        // Map each Reader entity to ReaderResponse
        return readers.stream().map(reader -> {
            ReaderResponse readerResponse = new ReaderResponse();
            readerResponse.setId(reader.getId());
            readerResponse.setFirstName(reader.getFirstName());
            readerResponse.setLastName(reader.getLastName());
            readerResponse.setEmail(reader.getEmail());
            readerResponse.setBooks(reader.getBooks().stream()
                    .map(book -> book.getTitle()) // Extract only book titles
                    .collect(Collectors.toList()));
            return readerResponse;
        }).collect(Collectors.toList());
    }
}
