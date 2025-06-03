package com.anirudh.bookstore.demo.dao;

import com.anirudh.bookstore.demo.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
