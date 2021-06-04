package com.mytion.sousacomics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.response.UserResponseBody;

@Mapper(componentModel = "spring")
public abstract class UserResponseMapper {
	
	public static final UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);
	
	public abstract UserResponseBody toUserResponseBody(User user);
}
