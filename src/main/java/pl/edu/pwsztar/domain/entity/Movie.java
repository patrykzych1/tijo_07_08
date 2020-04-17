package pl.edu.pwsztar.domain.entity;

import pl.edu.pwsztar.domain.dto.MovieDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "year")
    private Integer year;

    public Movie() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getYear() {
        return year;
    }

    private Movie(Builder builder){
        movieId = builder.movieId;
        title = builder.title;
        image = builder.image;
        year = builder.year;
    }

    public static final class Builder{
        private Long movieId;
        private String title;
        private String image;
        private Integer year;

        public Builder(){
        }

        public Builder movieId(Long movieId){
            this.movieId = movieId;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder image(String image){
            this.image = image;
            return this;
        }

        public Builder year(Integer year){
            this.year = year;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

}
