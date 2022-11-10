package com.enmivida.info.repository;

import com.enmivida.info.domain.MovieInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovieInfoRepository extends ReactiveMongoRepository<MovieInfo, String> {
    Flux<MovieInfo> findByYear(Integer year);
}
