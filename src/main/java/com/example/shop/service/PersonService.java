package com.example.shop.service;

import com.example.shop.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    Person getPersonById(Long id);

    void deletePerson(Long id);

    List<Person> getAllPerson();

    Person addShop(Long id, Long shopId);
}
