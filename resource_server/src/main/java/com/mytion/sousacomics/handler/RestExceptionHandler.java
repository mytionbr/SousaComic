package com.mytion.sousacomics.handler;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mytion.sousacomics.exception.BadRequestException;
import com.mytion.sousacomics.exception.BadRequestExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
					.timestamp(LocalDateTime.now())
					.status(HttpStatus.BAD_REQUEST.value())
					.title("Bad Request Exception, Check the Documentation")
					.details(bre.getMessage())
					.developerMessage(bre.getClass().getName())
					.build(),HttpStatus.BAD_REQUEST
			);
	}
}
