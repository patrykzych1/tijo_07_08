package pl.edu.pwsztar.domain.dto;

import org.springframework.core.io.InputStreamResource;

import java.util.List;

public class FileDto {
    private List<MovieDto> fileDtoList;

    public FileDto(List<MovieDto> fileDtoList) {
        this.fileDtoList = fileDtoList;
    }

    public List<MovieDto> getFileDtoList() {
        return fileDtoList;
    }
}
