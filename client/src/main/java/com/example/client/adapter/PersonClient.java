package com.example.client.adapter;

import com.example.client.dto.Person;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PersonClient {

    private final String url = "http://localhost:8080/api/person";

    private final RestTemplate restTemplate;

    public PersonClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<Person> getAll() {
        ParameterizedTypeReference<List<Person>> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<Person>> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return response.getBody();
    }

    public String savePerson(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Person> requestEntity = new HttpEntity<>(person, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        return response.getBody();
    }
}
