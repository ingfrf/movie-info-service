package com.enmivida.info;

import com.enmivida.info.domain.MovieInfo;
import com.enmivida.info.repository.MovieInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MovieInfoServiceApplication implements CommandLineRunner {

    private final MovieInfoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        /*List<MovieInfo> l = List.of(
                MovieInfo.builder().movieInfoId("123").name("Batman Begins").year(2005).cast(List.of("Christian Bale", "Michael Cane")).release_date(LocalDate.parse("2005-06-15")).build(),
                MovieInfo.builder().movieInfoId("456").name("The Dark Knight").year(2008).cast(List.of("Christian Bale", "Heath Ledger")).release_date(LocalDate.parse("2008-07-18")).build(),
                MovieInfo.builder().movieInfoId("789").name("Dark Knight Rises").year(2012).cast(List.of("Christian Bale", "Tom Hardy")).release_date(LocalDate.parse("2012-07-20")).build()
        );
        // recordar que estamos en mongodb REACTIVE
        repository.saveAll(l).blockLast();*/
    }
}
