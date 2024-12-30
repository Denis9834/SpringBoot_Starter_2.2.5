package ru.max.javaspringboot.SpringBootGet_223.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.max.javaspringboot.SpringBootGet_223.model.User;

import java.util.List;

@Service
public class IncomeService {

    private final String URL = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";
    private final RestTemplate restTemplate;

    @Autowired
    public IncomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getAllUsers() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        List<User> allUsers = responseEntity.getBody();

        return allUsers;
    }

    public double getUserIncome(Long userId) {
        User[] users = restTemplate.getForObject(URL, User[].class);

        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user.getIncome();
            }
        }
        return 0.0;
    }
}
