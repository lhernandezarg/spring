package com.prrin.http.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

}