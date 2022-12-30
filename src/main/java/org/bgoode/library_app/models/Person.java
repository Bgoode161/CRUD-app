package org.bgoode.library_app.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "The name should not be empty")
    @Size (min = 5, max = 30, message = "The name should be from 2 to 50 characters")
    private String name;

    @Min(value = 1900, message = "Year should be after 1900")
    @Max(value = 2014, message = "Year should be before 2014")
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
