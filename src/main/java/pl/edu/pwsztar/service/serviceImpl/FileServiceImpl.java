package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import pl.edu.pwsztar.domain.dto.FileDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.service.FileService;
import pl.edu.pwsztar.service.MovieService;

import java.io.*;
import java.util.List;

public class FileServiceImpl implements FileService {

    private final MovieService movieService;

    @Autowired
    public FileServiceImpl(MovieService movieService){
        this.movieService = movieService;
    }

    @Override
    public FileDto downloadTxt() throws IOException {
        File file = File.createTempFile("tmp", ".txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        writeMoviesToTxt(bufferedWriter);

        bufferedWriter.close();

        fileOutputStream.flush();
        fileOutputStream.close();

        InputStream stream = new FileInputStream(file);
        InputStreamResource inputStreamResource = new InputStreamResource(stream);

        return new FileDto(file.length(), inputStreamResource);
    }

    private void writeMoviesToTxt(BufferedWriter bufferedWriter)  throws IOException {
        List<MovieDto> moviesDto = movieService.findAllOrderedByYearDesc();

        for (MovieDto movieDto : moviesDto) {
            bufferedWriter.write(String.valueOf(movieDto));
            bufferedWriter.newLine();
        }
    }
}
