package com.prrin.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prrin.model.Article;

@Repository
public interface IArticlesRepository extends JpaRepository<Article, Integer> {

	@Query(value = "select a from Article a where a.publishedAt between :from and :to order by a.publishedAt desc")
	List<Article> findByBetweenPublishedAt(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}