package com.mytion.sousacomics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mytion.sousacomics.model.entity.Book;
import com.mytion.sousacomics.model.request.BookPostRequestBody;

@Mapper(componentModel = "spring")
public abstract class BookRequestMapper {
	
	public static final BookRequestMapper INSTANCE = Mappers.getMapper(BookRequestMapper.class);
	
	public abstract Book toBook(BookPostRequestBody bookPostRequestBody);
}
