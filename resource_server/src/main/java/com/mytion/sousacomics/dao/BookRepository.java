package com.mytion.sousacomics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytion.sousacomics.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
