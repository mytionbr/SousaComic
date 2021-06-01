package com.mytion.sousacomics.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponseBody {
	private String email;
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
