package com.mytion.sousacomics.service;

import java.util.List;

import com.mytion.sousacomics.model.entity.BookCategory;
import com.mytion.sousacomics.model.request.BookCategoryRequestBody;


public interface BookCategoryService {
	
	BookCategory save(BookCategoryRequestBody bookCategoryRequestBody);
	
	List<BookCategory> getAll();
}
