package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    /******
     * Fields
     ******/

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15, message = "Must be between 3-15 characters")
    @Column(unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();


    /******
     * Constructors
     ******/

    public Category() {}

    public Category(String name) {
        this.name = name;
    }


    /******
     * Getters and Setters
     ******/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
