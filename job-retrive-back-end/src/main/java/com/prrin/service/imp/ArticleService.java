package com.prrin.service.imp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prrin.model.Article;
import com.prrin.repository.IArticlesRepository;
import com.prrin.service.IArticlesService;

@Service
public class ArticleService implements IArticlesService {

	@Autowired
	private IArticlesRepository repo;

	@Override
	public int save(Article art) throws Exception {
		try {
			repo.save(art);
			return 200;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Article> getByFromAndTo(LocalDateTime from, LocalDateTime to) throws Exception {
		try {
			return repo.findByBetweenPublishedAt(from, to);
		} catch (Exception e) {
			throw e;
		}
	}

}