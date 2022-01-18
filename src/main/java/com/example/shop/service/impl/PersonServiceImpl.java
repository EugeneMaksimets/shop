package com.example.shop.service.impl;


import com.example.shop.convector.PersonConvector;
import com.example.shop.dto.PersonDTO;
import com.example.shop.model.Person;
import com.example.shop.service.PersonService;
import com.example.shop.storage.PersonStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonDTO createPerson(Person person) {
        PersonStorage.personStorageList.add(person);
        return PersonConvector.convectorToDTO(person);
    }

    @Override
    public PersonDTO updatePerson(Person person) {
        PersonDTO updatePerson = new PersonDTO();
        for (Person tmp : PersonStorage.personStorageList)
            if (tmp.getId().equals(person.getId())) {
                tmp.setCartId(person.getCartId());
                tmp.setName(person.getName());
                updatePerson = PersonConvector.convectorToDTO(tmp);
            }
        return updatePerson;
    }

    @Override
    public void deletePerson(Person person) {
        PersonStorage.personStorageList.removeIf(tmp -> tmp.getId().equals(person.getId()));
    }

    @Override
    public Person getPersonById(int id) {
        Person person = new Person();
        for (Person tmp : PersonStorage.personStorageList) {
            if (tmp.getId() == id) {
                person = tmp;
            }
        }
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        return PersonStorage.personStorageList;
    }
}
