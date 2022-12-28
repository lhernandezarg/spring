package com.prrin.mappers;

import org.springframework.stereotype.Component;

import com.prrin.http.response.ArticlesResponse;
import com.prrin.model.Article;

@Component
public class ArticlesMapper {

	public Article toArticle(ArticlesResponse rep) {
		Article art = new Article();

		art.setAuthor(rep.getAuthor());
		art.setTitle(rep.getTitle());
		art.setDescription(rep.getDescription());
		art.setUrl(rep.getUrl());
		art.setUrlToImage(rep.getUrlToImage());
		art.setPublishedAt(rep.getPublishedAt());
		art.setContent(rep.getContent());
		return art;

	}

}
