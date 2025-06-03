package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.AuthorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorDetailServiceImpl implements AuthorDetailService {
    AuthorDetailRepository authorDetailRepository;

    public AuthorDetailServiceImpl() {}

    @Autowired
    public AuthorDetailServiceImpl(AuthorDetailRepository authorDetailRepository) {
        this.authorDetailRepository = authorDetailRepository;
    }

    @Override
    public void deleteAuthorDetailById(int id) {
        authorDetailRepository.deleteById(id);
    }
}
