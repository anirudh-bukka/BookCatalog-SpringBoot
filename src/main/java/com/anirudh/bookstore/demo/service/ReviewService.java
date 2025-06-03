package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> listAllReviews();
    Review findReviewById(int id);
    Review saveReview(Review review);
    List<Review> listReviewsByBookId(int bookId);
    void deleteReviewById(int id);
}
