package mk.ukim.finki.wp.cmsproektnaapi.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileStorageService {
    String store(MultipartFile file) throws IOException;

    FileSystemResource get(String filename);
}
