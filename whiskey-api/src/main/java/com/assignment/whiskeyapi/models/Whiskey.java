package com.assignment.whiskeyapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "whiskeys")
public class Whiskey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String optionalName;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String category;

    @NotNull
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    public Whiskey(Integer id, String name, String optionalName, String origin, String category, Double price, String description) {
        this.id = id;
        this.name = name;
        this.optionalName = optionalName;
        this.origin = origin;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Whiskey(Whiskey whiskey) {
        this.id = whiskey.id;
        this.name = whiskey.name;
        this.optionalName = whiskey.optionalName;
        this.origin = whiskey.origin;
        this.category = whiskey.category;
        this.price = whiskey.price;
        this.description = whiskey.description;
    }

    public Whiskey() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptionalName() {
        return optionalName;
    }

    public void setOptionalName(String optionalName) {
        this.optionalName = optionalName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
