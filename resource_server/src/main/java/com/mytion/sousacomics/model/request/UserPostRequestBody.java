package com.mytion.sousacomics.model.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserPostRequestBody {
	@NotEmpty(message = "The user email cannot be empty")
	@NotNull(message = "The user email cannot be null")
	private String email;
	@NotEmpty(message = "The user password cannot be empty")
	@NotNull(message = "The user password cannot be null")
	@Min(value=5,message="The length of the user password must be at least 5 characters")
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String country;
	private String address;
	private String city;
	private String state;
	private String zip;
	private Date registrationDate;
}
