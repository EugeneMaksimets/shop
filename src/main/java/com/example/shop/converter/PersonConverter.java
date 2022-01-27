package com.example.shop.converter;

import com.example.shop.model.Person;

public class PersonConverter {
    public static Person personConverter(Person person, Person oldPerson) {
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setAge(person.getAge());
        oldPerson.setPhone(person.getPhone());
        return oldPerson;
    }
}
