package com.example.server.service;

import com.example.server.entity.Person;
import com.example.server.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Transactional(readOnly = true)
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Person getById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person with id " + id + " not found"));
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
