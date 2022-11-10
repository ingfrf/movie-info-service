package com.enmivida.info.service;

import com.enmivida.info.domain.MovieInfo;
import com.enmivida.info.repository.MovieInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieInfoService {

    private final MovieInfoRepository repository;

    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo) {
        return repository.save(movieInfo);
    }

    public Flux<MovieInfo> getAllMovieInfo() {
        return repository.findAll();
    }

    public Flux<MovieInfo> getMovieInfoByYear(Integer year) {
        return repository.findByYear(year);
    }

    public Mono<MovieInfo> getMovieInfoById(String id) {
        return repository.findById(id);
    }

    public Mono<MovieInfo> updateMovieInfo(MovieInfo updateMovieInfo, String id) {
        return repository.findById(id)
                .flatMap(movieInfo -> {
                    movieInfo.setCast(updateMovieInfo.getCast());
                    movieInfo.setName(updateMovieInfo.getName());
                    movieInfo.setYear(updateMovieInfo.getYear());
                    movieInfo.setRelease_date(updateMovieInfo.getRelease_date());
                    return repository.save(movieInfo);
                });
    }

    public Mono<Void> deleteMovieInfo(String id) {
        return repository.deleteById(id);
    }
}
