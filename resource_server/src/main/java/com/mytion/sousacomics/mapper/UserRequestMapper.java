package com.mytion.sousacomics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class UserRequestMapper {
	
	public static final UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);
	
	public abstract User toUser(UserPostRequestBody userPostRequestBody);
	public abstract User toUser(UserPutRequestBody userPutRequestBody);
	
}
