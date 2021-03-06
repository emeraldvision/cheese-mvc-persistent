package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Menu {

    @NotNull
    @Size(min = 3, max = 15, message = "Must be between 3-15 characters")
    @Column(unique = true)
    private String name;

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private List<Cheese> cheeses;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public void addItem(Cheese item) {
        cheeses.add(item);
    }

    public boolean hasCheese() {
        return this.getCheeses().size() > 0;
    }
}
