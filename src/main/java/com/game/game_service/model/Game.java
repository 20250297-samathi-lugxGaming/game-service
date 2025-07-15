package com.game.game_service.model;

import jakarta.persistence.*;
@Entity

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @Column(name = "release_date")
    private String releaseDate;

    private Double price;

    // No-args constructor
    public Game() {}

    // All-args constructor
    public Game(Long id, String name, String category, String releaseDate, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getReleaseDate() { return releaseDate; }
    public Double getPrice() { return price; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public void setPrice(Double price) { this.price = price; }
}
