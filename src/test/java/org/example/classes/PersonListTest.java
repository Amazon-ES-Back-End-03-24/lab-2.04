package org.example.classes;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PersonListTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    PersonList personList;

    @BeforeEach
    void init() {
        personList = new PersonList();
        person1 = new Person("Jaume Sánchez", 31, "Programmer");
        person2 = new Person("Pepe Sánchez", 32, "Marketing Executive");
        person3 = new Person("Antonia Torres", 21, "HR Intern");
        person4 = new Person("José Pérez", 21, "Finance");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

    }

    @Test
    void findByName_nameExactlyMatches_OK() {
        assertEquals(person1, personList.findByName("Jaume Sánchez"));

    }

    @Test
    void findByName_nameWithoutAccent_throwsException() {
        assertThrows(UnsupportedOperationException.class, () -> personList.findByName("Jaume Sanchez"));

    }

    @Test
    void findByName_emptyList_throwsException() {
        personList.removeAll();
        assertThrows(UnsupportedOperationException.class, () -> personList.findByName("Jaume Sánchez"));
    }

    @Test
    void findByName_nameMultipleTimes_returnsFirst() {
        person4.setName("Jaume Sánchez");
        assertEquals(person1.getId(), personList.findByName("Jaume Sánchez").getId());
    }
}