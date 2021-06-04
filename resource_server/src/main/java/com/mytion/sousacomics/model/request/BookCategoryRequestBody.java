package com.mytion.sousacomics.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BookCategoryRequestBody {
	@NotBlank(message = "The name of the category book is mandatory")
	private String name;
}
