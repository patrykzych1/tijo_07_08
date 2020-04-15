package pl.edu.pwsztar.service;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.FileDto;

import java.io.IOException;

@Component
public interface FileService {
    FileDto downloadTxt() throws IOException;
}
