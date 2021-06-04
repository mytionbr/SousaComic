package com.mytion.sousacomics.model.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.mytion.sousacomics.model.entity.BookCategory;

import lombok.Data;


@Data
public class BookPostRequestBody {
	@NotBlank(message="Book title cannot be empty or null")
	private String title;
	@NotBlank(message="Book author name cannot be empty or null")
	private String author;
	@NotBlank(message="Book image url cannot be empty or null")
	private String image;
	@NotBlank(message="Book price cannot be empty or null")
	private Float price;
	private String description;
	private Integer stock;
	private Integer numberPages;
	@NotEmpty(message="Book categories cannot be empty or null")
	private List<BookCategory> categories;
}
