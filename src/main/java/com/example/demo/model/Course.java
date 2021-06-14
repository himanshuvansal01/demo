package com.example.demo.model;

public class Course {

    private int id;
    private String Title;
    private String Description;


    public Course(int id, String title, String description) {
        this.id = id;
        this.Title = title;
        this.Description = description;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
