package ru.max.javaspringboot.SpringBootGet_223.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class IncomeService {

    private final String URL = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income/";
    private final RestTemplate restTemplate;

    @Autowired
    public IncomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double getIncomeByUserId(Long userId) {
            return restTemplate.getForObject(URL + userId, Double.class);
    }
}
