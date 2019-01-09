package mk.ukim.finki.wp.cmsproektnaapi.service.impl;

import mk.ukim.finki.wp.cmsproektnaapi.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Value("${upload.directory}")
    private String uploadDirectory;

    @Override
    public String store(MultipartFile file) throws IOException {
        UUID uuid = UUID.randomUUID();

        String[] parts = file.getOriginalFilename().split(".");
        String extension = ".jpg";
        if (parts.length > 0) {
            extension = "." + parts[parts.length - 1];
        }

        Path outputFileName = Paths.get(uploadDirectory, uuid.toString() + extension);
        Files.copy(file.getInputStream(), outputFileName);
        return outputFileName.getFileName().toString();
    }


    @Override
    public FileSystemResource get(String filename) {
        Path filePath = Paths.get(uploadDirectory, filename);
        if (Files.exists(filePath)) {
            FileSystemResource resource = new FileSystemResource(filePath);
            return resource;
        } else {
            return null;
        }
    }

}
