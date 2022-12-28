package com.prrin.http.service.imp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prrin.http.response.NewsApiResponse;
import com.prrin.http.service.INewsApiService;

@Service
public class NewsApiService implements INewsApiService {

	@Value("${api.url}")
	private String url;
	@Value("${api.key}")
	private String api_key;

	@Override
	public NewsApiResponse get(LocalDateTime from, LocalDateTime to, String search) throws Exception {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<NewsApiResponse> response = restTemplate.getForEntity(url(from, to, search, api_key),
					NewsApiResponse.class);

			return response.getBody();
		} catch (Exception e) {
			throw e;
		}
	}

	// https://newsapi.org/v2/everything?q=bitcoin&from=2022-12-25T07:00:00&to=2022-12-25T07:30:59&sortBy=popularity&apiKey=aa922b30f28943ee9eef5de8f531e74a

	private String url(LocalDateTime from, LocalDateTime to, String search, String api_key) {
		return url + "q=" + search + "&from=" + formatDate(from) + "&to=" + formatDate(to)
				+ "&sortBy=popularity&apiKey=" + api_key;
	}

	private String formatDate(LocalDateTime date) {
		String _date =date.toString().substring(0, 19);
		return _date;
	}
}