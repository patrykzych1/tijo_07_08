package pl.edu.pwsztar.domain.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.FileDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;
import pl.edu.pwsztar.service.MovieService;

import java.io.*;

import java.util.List;

@Service
public class FileGeneratorImpl implements FileGenerator {
    private MovieService movieService;

    @Autowired
    public FileGeneratorImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public InputStreamResource toTxt(FileDto fileDto) throws IOException {

        File file = File.createTempFile("tmp", ".txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        List<MovieDto> movieDtoList = movieService.findAllOrderedByYearDesc();
        for (MovieDto movieDto : movieDtoList) {
            bufferedWriter.write(movieDto.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        fileOutputStream.flush();
        fileOutputStream.close();

        InputStream stream = new FileInputStream(file);
        return new InputStreamResource(stream);
    }
}
