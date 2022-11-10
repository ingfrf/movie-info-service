package com.enmivida.info.controller;

import com.enmivida.info.domain.MovieInfo;
import com.enmivida.info.service.MovieInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MovieInfoController {

    private final MovieInfoService service;

    @PostMapping("/movieinfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovieInfo> addMovieInfo(@RequestBody @Valid MovieInfo movieInfo) {
        return service.addMovieInfo(movieInfo)
                .log();
    }

    @GetMapping("/movieinfos")
    // year es opcional
    public Flux<MovieInfo> getAllMovieInfo(@RequestParam(value="year", required = false) Integer year) {
        if (year != null) {
            return service.getMovieInfoByYear(year)
                    .log();
        }
        return service.getAllMovieInfo()
                .log();
    }

    @GetMapping("/movieinfos/{id}")
    public Mono<MovieInfo> getMovieInfoById(@PathVariable String id) {
        return service.getMovieInfoById(id)
                .log();
    }

    @PutMapping("/movieinfos/{id}")
    public Mono<ResponseEntity<MovieInfo>> updateMovieInfo(@RequestBody MovieInfo movieInfo, @PathVariable String id) {
        return service.updateMovieInfo(movieInfo, id)
                // viene siendo movInfo -> ResponseEntity.ok().body(movInfo)
                .map(ResponseEntity.ok()::body)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
                .log();
    }

    @DeleteMapping("/movieinfos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMovieInfo(@PathVariable String id) {
        return service.deleteMovieInfo(id)
                .log();
    }
}
