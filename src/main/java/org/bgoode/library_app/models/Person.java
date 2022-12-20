package org.bgoode.library_app.models;

public class Person {
    private int id;

    private String name;
    private int birthDate;

    public Person() {}

    public Person(int id, String name, int birthDate) {this.id = id; this.name = name; this.birthDate = birthDate; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
