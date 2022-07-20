package com.nology.greeting;

import java.time.LocalDate;

// MODEL -> STORING DATA -> PLAIN OLD JAVA OBJECT -> POJO
// SPRING IS ABLE TO CREATE THIS AS IT HAS A CONSTRUCTOR GETTERS & SETTERS
public class Greeting {
    private String id;
    private String createdBy;
    private String greeting;
    private String originCountry;
    private String nationality;
    private LocalDate dateCreated = LocalDate.now();

    public Greeting(String id, String createdBy, String greeting, String originCountry, String nationality) {
        this.id = id;
        this.createdBy = createdBy;
        this.greeting = greeting;
        this.originCountry = originCountry;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String Nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
