package com.mytion.sousacomics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mytion.sousacomics.model.entity.BookCategory;
import com.mytion.sousacomics.model.request.BookCategoryRequestBody;

@Mapper(componentModel = "spring")
public abstract class  BookCategoryRequestMapper {
	public static final BookCategoryRequestMapper INSTANCE = Mappers.getMapper(BookCategoryRequestMapper.class);
	
	public abstract BookCategory toBookCategory(BookCategoryRequestBody bookCategoryRequestBody);
	
}
