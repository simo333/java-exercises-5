package com.example.javaexercises5.advanced.dao;

public class Exercise implements Model {
    private Long id;
    private String title;
    private String description;

    public Exercise(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Exercise(String title, String description) {
        this(null, title, description);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Exercise setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Exercise setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s]", getId(), getTitle(), getDescription());
    }
}
