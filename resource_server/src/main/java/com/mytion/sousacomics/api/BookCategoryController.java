package com.mytion.sousacomics.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytion.sousacomics.model.entity.BookCategory;
import com.mytion.sousacomics.model.request.BookCategoryRequestBody;
import com.mytion.sousacomics.service.BookCategoryService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/bookCategories")
@RestController
@RequiredArgsConstructor
public class BookCategoryController extends ApiController{
	
	private final BookCategoryService bookCategoryService;
	
	@GetMapping
	public List<BookCategory> listAll(){
		return this.bookCategoryService.getAll();
	}
	
	@PostMapping
	public BookCategory save(@RequestBody @Valid BookCategoryRequestBody bookCategoryRequestBody) {
		return this.bookCategoryService.save(bookCategoryRequestBody);
	}
}
