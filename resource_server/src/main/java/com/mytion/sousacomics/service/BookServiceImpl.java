package com.mytion.sousacomics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytion.sousacomics.dao.BookRepository;
import com.mytion.sousacomics.mapper.BookRequestMapper;
import com.mytion.sousacomics.model.entity.Book;
import com.mytion.sousacomics.model.request.BookPostRequestBody;

@Service
public class BookServiceImpl implements BookService{
	
	private final BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book save(BookPostRequestBody bookPostRequestBody) {
		Book book = BookRequestMapper.INSTANCE.toBook(bookPostRequestBody);
		return this.bookRepository.save(book);
	}
	
	
}
