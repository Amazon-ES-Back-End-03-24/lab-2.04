package org.example.classes;

import org.example.utils.Validator;

import java.util.Objects;

public class Person {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        // forcing the id to be a counter
        id = idCounter++;
        setName(name);
        setAge(age);
        this.occupation = occupation;
    }

    public Person() {
        // empty constructor, normally useful for tests
    }

    // not used in the code
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    // added: clone method takes Person object and returns a nearly identical object with new id.
    @Override
    public Person clone() {
        return new Person(name, age, occupation);
    }

    // override the equals method in the Person class to test for equivalency excluding id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // excluding the id:
        return getAge() ==
                person.getAge() && getName().equals(person.getName()) && getOccupation().equals(person.getOccupation());
    }

    @Override
    public int hashCode() {
        // excluding the id:
        return Objects.hash(getName(), getAge(), getOccupation());
    }

    @Override
    public String toString() {
        return "Person:" + name +
                "\nid=" + id +
                "\nage=" + age +
                "\noccupation='" + occupation + '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.checkName(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Validator.checkAge(age);
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}