package com.example.demo.services;

import com.example.demo.model.Person;

public class PersonService {

    private Person person;

    public PersonService() {
        this.person = new Person("Fred", 25);
    }

    public Person findPerson() {
        return person;
    }

    public void createPerson(String name, int age) {
        this.person = new Person(name, age);
    }
}
