package org.example.classes;

import org.example.utils.Validator;

import java.util.ArrayList;

public class PersonList {
    private ArrayList<Person> persons;

    public PersonList() {
        persons = new ArrayList<>();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public void removeAll() {
        persons = new ArrayList<>();
    }

    public Person findByName(String name) {
        Validator.checkName(name);
        Person result;

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                result = person;
                return result;
            }
        }

        throw new UnsupportedOperationException("Name not found");
    }

    // clone is done in Person class and write in Validator class
}