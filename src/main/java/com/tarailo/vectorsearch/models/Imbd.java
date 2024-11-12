package com.tarailo.vectorsearch.models;

public class Imbd {
    private double rating;

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int Votes;
    private int id;
}
