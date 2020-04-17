package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.converter.Converter;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

@Component
public class MovieMapper implements Converter<CreateMovieDto, Movie> {

    @Override
    public Movie convert(CreateMovieDto createMovieDto) {

        return new Movie.Builder()
                .title(createMovieDto.getTitle())
                .image(createMovieDto.getImage())
                .year(createMovieDto.getYear())
                .build();
    }
}
