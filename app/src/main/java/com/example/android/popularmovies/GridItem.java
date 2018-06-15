package com.example.android.popularmovies;

/**
 * Created by Shubham on 6/14/2018.
 * Model Class
 */

public class GridItem {

    private float rating;

    private double popularity;

    private String movieTitle;

    private String imageUrl;

    public float getRating() {
        return rating;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
