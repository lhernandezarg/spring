package com.prrin.configuration;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.prrin.http.response.ArticlesResponse;
import com.prrin.http.response.NewsApiResponse;
import com.prrin.http.service.INewsApiService;
import com.prrin.mappers.ArticlesMapper;
import com.prrin.service.IArticlesService;

@Configuration
@EnableScheduling
public class JobRetrival {

	@Autowired
	private INewsApiService httpService;

	@Autowired
	private IArticlesService service;

	@Autowired
	private ArticlesMapper mapper;

	private Logger logger = LoggerFactory.getLogger(JobRetrival.class);

	@Value("${api.default.search}")
	private String default_value_search;

	@Scheduled(fixedDelay = 600000, initialDelay = 3000)
	public void fixedDelaySch() throws Exception {

		try {

			logger.info("Retrive Data");

			LocalDateTime from = LocalDateTime.now();
			LocalDateTime to = from.plusMinutes(10);
			
			NewsApiResponse response = httpService.get(from, to, default_value_search);
			
			logger.info("from: " + from.toString());
			logger.info("to: " + to.toString());

			for (ArticlesResponse r : response.getArticles()) {
				service.save(mapper.toArticle(r));
			}

			logger.info("Data Retrival!");

		} catch (Exception e) {

			throw e;
		}
	}
}