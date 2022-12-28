package com.prrin.http.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private Integer totalResults;
	private List<ArticlesResponse> articles;

}
