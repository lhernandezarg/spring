package com.prrin.controller.common;

import com.prrin.controller.response.ErrorResponse;
import com.prrin.exceptions.ResourceNotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptions {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(), ex.getLocalizedMessage(),
				request.getDescription(false));

		return message;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
				ex.getLocalizedMessage(), request.getDescription(false));
		return message;
	}
}
