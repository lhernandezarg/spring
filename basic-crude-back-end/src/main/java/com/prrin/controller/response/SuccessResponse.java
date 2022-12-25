package com.prrin.controller.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String icon;
	private String title;
	private String text;
	private String confirmButtonText;
	private T item;
}
