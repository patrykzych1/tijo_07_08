package pl.edu.pwsztar.domain.dto;

import org.springframework.core.io.InputStreamResource;

public class FileDto {
    private long fileLength;
    private InputStreamResource inputStreamResource;

    public FileDto(long fileLength, InputStreamResource inputStreamResource){
        this.fileLength = fileLength;
        this.inputStreamResource = inputStreamResource;
    }

    public long getFileLength() {
        return fileLength;
    }

    public InputStreamResource getInputStreamResource() {
        return inputStreamResource;
    }
}
