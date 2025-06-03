package com.anirudh.bookstore.demo.service;

import com.anirudh.bookstore.demo.dao.ReviewRepository;
import com.anirudh.bookstore.demo.entity.Reader;
import com.anirudh.bookstore.demo.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl() {}

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(int id) {
        Optional<Review> tempReview = reviewRepository.findById(id);

        Review review = null;
        if(tempReview.isPresent())
            review = tempReview.get();
        else
            throw new RuntimeException("Reader with id: " + id + " not found.");

        return review;
    }

    @Override
    @Transactional
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> listReviewsByBookId(int bookId) {
        return List.of();
    }

    @Override
    @Transactional
    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
}
