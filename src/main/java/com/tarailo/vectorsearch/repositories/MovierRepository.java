package com.tarailo.vectorsearch.repositories;

import com.tarailo.vectorsearch.models.Movie;
import reactor.core.publisher.Flux;

import java.util.List;

public interface MovierRepository {

    Flux<Movie> findMovieByVector(List<Double> embedding);
}
