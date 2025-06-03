package com.anirudh.bookstore.demo.rest;

import com.anirudh.bookstore.demo.service.AuthorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorDetailsApi")
public class AuthorDetailRestController {
    AuthorDetailService authorDetailService;

    public AuthorDetailRestController() {}

    @Autowired
    public AuthorDetailRestController(AuthorDetailService authorDetailService) {
        this.authorDetailService = authorDetailService;
    }

    @DeleteMapping("/authorDetailsApi/{authorDetailId}")
    public String deleteAuthorDetail(@PathVariable int authorDetailId) {
        authorDetailService.deleteAuthorDetailById(authorDetailId);
        return "Deleted author details of id: " + authorDetailId;
    }
}
