package com.example.shop.service;

import com.example.shop.dto.PersonDTO;
import com.example.shop.model.Person;

import java.util.List;

public interface PersonService {
    PersonDTO createPerson(Person person);

    PersonDTO updatePerson(Person person);

    void deletePerson(Person person);

    Person getPersonById(int id);

    List<Person> getAllPerson();

}
