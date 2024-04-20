package org.example.utils;

import org.example.classes.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ValidatorTest {
    @Test
    void checkName_nameIsValid_returnsTrue() {
        assertTrue(Validator.checkName("Jaume Sanchez"));
        assertTrue(Validator.checkName("Jaume Sánchez"));
        assertTrue(Validator.checkName("Jañume Sánchez"));
        assertTrue(Validator.checkName("Jaúme Sánchez"));
    }

    @Test
    void checkName_nameNoSpaces_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("JaumeSanchez"));
    }

    @Test
    void checkName_nameTwoSpaces_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jaume Sanchez Torres"));
    }

    @Test
    void checkName_nameSpacesBetweenAndEnd_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName(" Jaume Sanchez"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jaume Sanchez "));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName(" Jaume Sanchez "));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jaume  Sanchez"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName(" Jaume  Sanchez"));
    }

    @Test
    void checkName_digitsAndSpecialCharacters_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("65784 8568"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("3543514354635"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("jaume @gmail"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("987654 Sanchez"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jaume 564654"));
    }

    @Test
    void checkAge_validAge_returnsTrue() {
        assertTrue(Validator.checkAge(10));
        assertTrue(Validator.checkAge(0));

    }

    @Test
    void checkAge_negativeAge_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkAge(-1));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkAge(-10));
    }


    @Test
    void writePerson_writesPerson_OK() {
        Person person = new Person("Jaume Sánchez", 32, "Programmer");
        assertTrue(Validator.writePerson(person));
    }

    @Test
    void writePerson_rewritesSamePerson_OK() {
        Person person = new Person("Jaume Sánchez", 35, "Programmer");
        assertTrue(Validator.writePerson(person));
    }
}