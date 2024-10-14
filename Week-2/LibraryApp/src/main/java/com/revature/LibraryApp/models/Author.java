package com.revature.LibraryApp.models;

import java.util.Date;

public class Author {
    private int authorId;
    private String name;
    private String biography;
    private Date birthDate;

    // Constructor
    public Author(int authorId, String name, String biography, Date birthDate) {
        this.authorId = authorId;
        this.name = name;
        this.biography = biography;
        this.birthDate = birthDate;
    }

    public Author(){}

    // Getters and Setters
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // toString method
    @Override
    public String toString() {
        return "Author{" +
                "id=" + authorId +
                ", name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}