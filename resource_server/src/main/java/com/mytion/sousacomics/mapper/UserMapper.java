package com.mytion.sousacomics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
	
	public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	public abstract User toUser(UserPostRequestBody userPostRequestBody);
	public abstract User toUser(UserPutRequestBody userPutRequestBody);
}
