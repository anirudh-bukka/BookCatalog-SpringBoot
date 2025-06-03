package com.anirudh.bookstore.demo.rest;

import com.anirudh.bookstore.demo.dto.AuthorRequest;
import com.anirudh.bookstore.demo.entity.Author;
import com.anirudh.bookstore.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorsApi")
public class AuthorRestController {
    private AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> retrieveAllAuthors() {
        return authorService.listAllAuthors();
    }

    @GetMapping("/authors/{authorId}")
    public Author retrieveAuthorById(@PathVariable int authorId) {
        return authorService.findAuthorById(authorId);
    }

    @PostMapping("/authors")
    public Author addAuthorWithAuthorDetail(@RequestBody AuthorRequest authorRequest) {
        // Create new Author instance
        Author author = new Author();
        author.setFirstName(authorRequest.getAuthor().getFirstName());
        author.setLastName(authorRequest.getAuthor().getLastName());
        author.setEmail(authorRequest.getAuthor().getEmail());

        // Set AuthorDetail for the Author
        if (authorRequest.getAuthorDetail() != null) {
            author.setAuthorDetail(authorRequest.getAuthorDetail());
            author.getAuthorDetail().setAuthor(author); // Set bidirectional relationship
        }

// //         Set Books if provided
//        if (authorRequest.getBooks() != null && !authorRequest.getBooks().isEmpty()) {
//            authorRequest.getBooks().forEach(book -> {
//                book.setAuthor(author); // Set bidirectional relationship
//            });
//            author.setBooks(authorRequest.getBooks());
//        }

        // Save the Author with all related data
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/authors/{authorId}")
    public String deleteAuthor(@PathVariable int authorId) {
        authorService.deleteAuthorById(authorId);
        return "Deleted author with id: " + authorId;
    }
}
