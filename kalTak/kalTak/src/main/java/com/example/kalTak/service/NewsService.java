package com.example.kalTak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    String baseUrl = "https://newsapi.org/v2/top-headlines";
    String url = "http://localhost:9999/person"; 

    public Object getNews(String source,
                          String apiKey) {
        String url = prepareUrl(source,apiKey);
        return restTemplate.getForObject(url,Object.class);
    }

    private String prepareUrl(String source,
                              String apiKey) {
        return baseUrl + "?sources=" + source + "&apiKey="+apiKey;
    }
}
