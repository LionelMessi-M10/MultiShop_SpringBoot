package com.multishop.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {

    private final String uploadDir = "src/main/resources/static/images";

    public String uploadFile(MultipartFile file, String targetFolder) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
        Path folderPath = Paths.get(uploadDir, targetFolder);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String fileName = file.getOriginalFilename();
        Path filePath = folderPath.resolve(fileName);
        file.transferTo(filePath.toFile());
        return filePath.toString();
    }
}
