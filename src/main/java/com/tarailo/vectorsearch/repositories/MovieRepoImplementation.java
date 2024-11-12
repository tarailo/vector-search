package com.tarailo.vectorsearch.repositories;

import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.tarailo.vectorsearch.models.Movie;
import org.bson.conversions.Bson;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.mongodb.client.model.Aggregates.vectorSearch;
import static com.mongodb.client.model.search.SearchPath.fieldPath;
import static java.util.Arrays.asList;

public class MovieRepoImplementation  implements MovierRepository{
    private final MongoDatabase mongoDatabase;

    public MovieRepoImplementation(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    private MongoCollection<Movie> getMovieCollection(){
        return mongoDatabase.getCollection("embedded_movies", Movie.class);
    }

    @Override
    public Flux<Movie> findMovieByVector(List<Double> embedding) {
        String indexName = "vector_index";
        int numCandidate = 100;
        int limit = 5;

        List<Bson> pipeline = asList(
                vectorSearch(
                        fieldPath("plot_embedding"),
                        embedding,
                        indexName,
                        numCandidate,
                        limit
                ));

        return Flux.from(getMovieCollection().aggregate(pipeline, Movie.class));
    }
}
