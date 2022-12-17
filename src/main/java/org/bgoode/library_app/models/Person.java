package org.bgoode.library_app.models;

public class Person {

    private String name;
    private int birthDate;

    public Person() {}

    public Person(String name, int birthDate) { this.name = name; this.birthDate = birthDate; }

    public String getName() {
        return name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
}
