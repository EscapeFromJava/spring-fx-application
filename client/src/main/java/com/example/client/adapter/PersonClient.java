package com.example.client.adapter;

import com.example.client.model.dto.PersonDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PersonClient {

    private static final String URL = "http://localhost:8080/api/person";
    private final RestTemplate restTemplate;

    public PersonClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<PersonDto> getAll() {
        ResponseEntity<List<PersonDto>> response = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    public String savePerson(PersonDto personDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PersonDto> requestEntity = new HttpEntity<>(personDto, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(URL, requestEntity, String.class);
        return response.getBody();
    }

    public void removePerson(PersonDto selectedPerson) {
        restTemplate.delete(URL + "/{id}", selectedPerson.getId());
    }
}
