package com.anirudh.bookstore.demo.dao;

import com.anirudh.bookstore.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
