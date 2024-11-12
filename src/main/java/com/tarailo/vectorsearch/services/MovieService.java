package com.tarailo.vectorsearch.services;

import com.tarailo.vectorsearch.models.Movie;
import com.tarailo.vectorsearch.repositories.MovierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.List;

public class MovieService {
    private final MovierRepository movierRepository;
    private final OpenAIService embedder;

    @Autowired
    public MovieService(MovierRepository movierRepository, OpenAIService embedder) {
        this.movierRepository = movierRepository;
        this.embedder = embedder;
    }

    public Mono<List<Movie>> getMoviesSearch(String plotDescription){
        return embedder.createEmbedding(plotDescription)
                .flatMapMany(movierRepository::findMovieByVector)
                .collectList();
    }
}
