package com.prrin.controller.response;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;

}