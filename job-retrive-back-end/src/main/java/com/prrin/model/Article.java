package com.prrin.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles", schema = "public")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 500)
	private String author;

	@Column(length = 500)
	private String title;

	@Column(length = 5000)
	private String description;

	@Column(length = 1000)
	private String url;

	@Column(length = 1000)
	private String urlToImage;
	
	@Column
	private LocalDateTime publishedAt;

	@Column(length = 10000)
	private String content;

}