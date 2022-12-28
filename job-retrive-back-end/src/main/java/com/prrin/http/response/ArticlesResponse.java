package com.prrin.http.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private SourceResponse source;
	
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private LocalDateTime publishedAt;
	private String content;

}
