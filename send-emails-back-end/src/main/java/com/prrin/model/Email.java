package com.prrin.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email implements Serializable {

	private static final long serialVersionUID = 1L;

	private String to;
	private String[] cc;
	private String subject;
	private String content;
	
	
	
	
	

}
