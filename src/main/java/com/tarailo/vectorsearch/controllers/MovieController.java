package com.tarailo.vectorsearch.controllers;

import com.tarailo.vectorsearch.models.Movie;
import com.tarailo.vectorsearch.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.List;

public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/semantic-search")
    public Mono<List<Movie>> performSemanticSearch(@RequestParam("plotDescription") String plotDescription){
        return movieService.getMoviesSearch(plotDescription);
    }
}
