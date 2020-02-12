package com.twu.biblioteca.Logic;

public class Movie {
    private final String title;
    private final int year;
    private final String director;
    private final int rating;

    public Movie(String title, int year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }
}
