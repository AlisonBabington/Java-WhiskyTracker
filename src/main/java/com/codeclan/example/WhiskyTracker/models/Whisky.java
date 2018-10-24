package com.codeclan.example.WhiskyTracker.models;

import javax.persistence.*;

@Entity
@Table(name = "whiskies")
public class Whisky {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "distillery_id", nullable = false)
    private Distillery distillery;

    public Whisky(String name, int age,int year, Distillery distillery) {
        this.name = name;
        this.age = age;
        this.year = year;
        this.distillery = distillery;
    }

    public Whisky() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Distillery getDistillery() {
        return distillery;
    }

    public void setDistillery(Distillery distillery) {
        this.distillery = distillery;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
//
//    Given the basic code for classes and JpaRepositories for a whisky tracker, your task for this lab +
//        homework is to complete the custom queries and connected them to appropriate RESTful endpoints.
//
//
//        MVP
//        Custom Queries + REST Write each of the following queries and connect them to an appropriate controller:
//        get all the whiskies for a particular year
//        get all the whisky from a particular region
//        get all the distilleries for a particular region
//        get all the whisky from a particular distillery that's a specific age (if any)
//        Get disilleries that have whiskies that are 12 years old
//        Tips
//        Use a ddl-auto setting of create-drop when doing development. This means every time the app starts, the schema is created,
//        and when the app stops the schema is destroyed.
//        Use packages for each repository type. For example, all Distillery repositories (Custom, Impl and actual) should go in the
//        same package called DistilleryRepository