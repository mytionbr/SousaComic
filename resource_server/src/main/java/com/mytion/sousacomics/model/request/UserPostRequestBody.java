package com.mytion.sousacomics.model.request;

import java.util.Date;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
public class UserPostRequestBody {
	private String email;
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
