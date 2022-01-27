package com.example.shop.controller;

import com.example.shop.model.Person;
import com.example.shop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/person/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/person/all")
    public List<Person> getAll() {
        return personService.getAllPerson();
    }

    @PutMapping("person/{id}/add/shop/{shopId}")
    public Person addShop(@PathVariable Long id, @PathVariable Long shopId) {
        return personService.addShop(id, shopId);
    }
}