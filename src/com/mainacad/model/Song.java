package com.mainacad.model;

public class Song {
    private String name;
    private String author;
    private Integer durationSeconds;

    public Song(String name, String author, Integer durationSeconds) {
        this.name = name;
        this.author = author;
        this.durationSeconds = durationSeconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
}
