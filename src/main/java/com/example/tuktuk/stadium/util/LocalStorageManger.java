package com.example.tuktuk.stadium.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class LocalStorageManger extends StorageManger{
    @Override
    public String put(MultipartFile image){
        StringBuilder saveImagePathString = new StringBuilder(this.getStorageDestination())
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
    public MultipartFile get(String imageDestination){ return null; }
}
