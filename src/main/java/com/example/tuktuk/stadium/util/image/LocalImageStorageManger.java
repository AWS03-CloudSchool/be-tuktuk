package com.example.tuktuk.stadium.util.image;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
@Getter
public class LocalImageStorageManger extends ImageStorageManger {

    private final String storageDestination;

    public LocalImageStorageManger(@Value("$(app.image-base-path}") String baseImagePath){
        super(baseImagePath);
        this.storageDestination = baseImagePath;
    }

    @Override
    public String putImage(MultipartFile image) {
        StringBuilder saveImagePathString = new StringBuilder(storageDestination)
                .append(File.separator)
                .append(UUID.randomUUID())
                .append("_")
                .append(image.getOriginalFilename());

        Path saveImagePath = Paths.get(saveImagePathString.toString());

        try {
            image.transferTo(saveImagePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return saveImagePathString.toString();
    }

    @Override
    public MultipartFile getImage(String imageDestination) {
        return null;
    }
}
