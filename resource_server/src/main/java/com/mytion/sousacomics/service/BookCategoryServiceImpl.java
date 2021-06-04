package com.mytion.sousacomics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytion.sousacomics.dao.BookCategoryRepository;
import com.mytion.sousacomics.mapper.BookCategoryRequestMapper;
import com.mytion.sousacomics.model.entity.BookCategory;
import com.mytion.sousacomics.model.request.BookCategoryRequestBody;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
	
	private final BookCategoryRepository bookCategoyRepository;
	
	@Autowired
	public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
		this.bookCategoyRepository = bookCategoryRepository;
	}
	
	@Override
	public BookCategory save(BookCategoryRequestBody bookCategoryRequestBody) {
		BookCategory bookCategory = BookCategoryRequestMapper.INSTANCE.toBookCategory(bookCategoryRequestBody);
		return this.bookCategoyRepository.save(bookCategory);
	}

	@Override
	public List<BookCategory> getAll() {
		return this.bookCategoyRepository.findAll();
	}

}
