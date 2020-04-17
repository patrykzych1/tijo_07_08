package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.converter.Converter;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieListMapper implements Converter<List<Movie>, List<MovieDto>> {
    @Override
    public List<MovieDto> convert(List<Movie> from) {

        return from.stream()
                .map(movie -> {
                    MovieDto movieDto = new MovieDto.Builder()
                            .movieId(movie.getMovieId())
                            .image(movie.getImage())
                            .title(movie.getTitle())
                            .year(movie.getYear())
                            .build();

                    return movieDto;
                })
                .collect(Collectors.toList());

    }
}
