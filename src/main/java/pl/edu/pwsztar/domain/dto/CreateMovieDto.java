package pl.edu.pwsztar.domain.dto;

import java.io.Serializable;

public class CreateMovieDto implements Serializable {
    private String title;
    private String image;
    private Integer year;

    public CreateMovieDto() {
    }

    private CreateMovieDto(Builder builder) {
        title = builder.title;
        image = builder.image;
        year = builder.year;
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

    @Override
    public String toString() {
        return "CreateMovieDto{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", year=" + year +
                '}';
    }

    public static final class Builder {
        private String title;
        private String image;
        private Integer year;

        public Builder() {
        }

        public Builder(CreateMovieDto createMovieDto) {
            this.title = createMovieDto.getTitle();
            this.image = createMovieDto.getImage();
            this.year = createMovieDto.getYear();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public CreateMovieDto build() {
            return new CreateMovieDto(this);
        }
    }
}
