package com.anirudh.bookstore.demo.dao;

import com.anirudh.bookstore.demo.entity.AuthorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDetailRepository extends JpaRepository<AuthorDetail, Integer> {
}
