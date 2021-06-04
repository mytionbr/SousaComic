package com.mytion.sousacomics.service;

import com.mytion.sousacomics.model.entity.Book;
import com.mytion.sousacomics.model.request.BookPostRequestBody;

public interface BookService {
	
	Book save(BookPostRequestBody bookPostRequestBody);
}
