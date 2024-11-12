package com.tarailo.vectorsearch.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Movie {

    @BsonProperty("_id")
    private ObjectId id;
    private String title;
    private int year;
    private int runtime;
    private Date released;
    private String poster;
    private String plot;
    private String lastUpdated;
    private String type;
    private List<String> directors;
    private Imbd imbd;
    private List<String> cast;
    private List<String> countries;
    private List<String> genres;
    private Tomatoes tomatoes;
    private int num_mflix_comments;
    private String plot_embeddings;
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public Imbd getImbd() {
        return imbd;
    }

    public void setImbd(Imbd imbd) {
        this.imbd = imbd;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Tomatoes getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Tomatoes tomatoes) {
        this.tomatoes = tomatoes;
    }

    public int getNum_mflix_comments() {
        return num_mflix_comments;
    }

    public void setNum_mflix_comments(int num_mflix_comments) {
        this.num_mflix_comments = num_mflix_comments;
    }

    public String getPlot_embeddings() {
        return plot_embeddings;
    }

    public void setPlot_embeddings(String plot_embeddings) {
        this.plot_embeddings = plot_embeddings;
    }


}
