package mk.ukim.finki.wp.cmsproektnaapi.web.rest;

import mk.ukim.finki.wp.cmsproektnaapi.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(value = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileUploadResource {
    FileStorageService fileStorageService;

    @Autowired
    public FileUploadResource(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fileStorageService.store(file);
    }

    @GetMapping(value = "/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public FileSystemResource serveFile(@PathVariable String filename, HttpServletResponse response) {
        FileSystemResource resource = fileStorageService.get(filename);
        if (filename.endsWith(".jpg")) {
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        } else if (filename.endsWith(".png")) {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }
        return resource;
    }

    @GetMapping(value = "/")
    public String test() {
        return "test";
    }
}
