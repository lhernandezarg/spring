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

	private int value;
	private Date date;
	private String localizedMessage;
	private String description;

	private static final long serialVersionUID = 1L;

}
