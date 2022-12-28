package com.prrin.http.service;

import java.time.LocalDateTime;

import com.prrin.http.response.NewsApiResponse;

public interface INewsApiService {

	NewsApiResponse get(LocalDateTime from, LocalDateTime to, String search) throws Exception;

}