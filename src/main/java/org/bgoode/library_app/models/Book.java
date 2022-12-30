package org.bgoode.library_app.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty
    @Size(min = 2, max = 50, message = "The title should be from 2 to 50 characters" )
    private String title;
    @NotEmpty
    @Size(min = 2, max = 50, message = "The author's Full Name should be from 2 to 50 characters" )
    private String author;
    @Min(value = 1600, message = "Year should be after 1600")
    @Max(value = 2022, message = "Year should be before 2022")
    private int year;
    public Book(){}

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
