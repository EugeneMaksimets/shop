package com.example.shop.service.impl;

import com.example.shop.converter.PersonConverter;
import com.example.shop.model.Person;
import com.example.shop.model.Shop;
import com.example.shop.repository.PersonRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Person oldPerson = personRepository.findById(person.getId()).orElseGet(Person::new);
        return personRepository.save(PersonConverter.personConverter(person, oldPerson));
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseGet(Person::new);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person addShop(Long id, Long shopId) {
        Person person = personRepository.findById(id).get();
        Shop shop = shopRepository.findById(shopId).get();
        List<Person> personList = shop.getPersonList();
        personList.add(person);
        shop.setPersonList(personList);
        person.setShop(shop);
        shopRepository.save(shop);
        return personRepository.save(person);
    }
}

