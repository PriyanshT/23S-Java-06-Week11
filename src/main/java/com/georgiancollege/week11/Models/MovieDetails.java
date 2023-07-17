package com.georgiancollege.week11.Models;

import com.google.gson.annotations.SerializedName;

public class MovieDetails {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Released")
    private String releaseDate;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Writer")
    private String writer;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Ratings")
    private Rating[] rating;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPoster() {
        return poster;
    }

    public Rating[] getRating() {
        return rating;
    }
}
