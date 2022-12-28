package com.prrin.service;

import java.time.LocalDateTime;
import java.util.List;

import com.prrin.model.Article;

public interface IArticlesService {

	int save(Article art) throws Exception;

	List<Article> getByFromAndTo(LocalDateTime from, LocalDateTime to) throws Exception;

}
