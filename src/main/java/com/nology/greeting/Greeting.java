package com.nology.greeting;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

// MODEL -> STORING DATA -> PLAIN OLD JAVA OBJECT -> POJO
// SPRING IS ABLE TO CREATE THIS AS IT HAS A CONSTRUCTOR GETTERS & SETTERS
@Entity
public class Greeting {
    // ID - Primary Key
    // Spring will automatically generate the ID
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String id;
    private String createdBy;
    private String greeting;
    private String originCountry;
    private String nationality;
    private LocalDate dateCreated = LocalDate.now();

    // Spring needs an empty constructor
    // Uses the empty constructor to create a class and use getters and setters to add values
    public Greeting() {

    }

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

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
