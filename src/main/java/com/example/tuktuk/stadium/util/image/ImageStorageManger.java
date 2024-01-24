package com.example.tuktuk.stadium.util.image;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
public abstract class ImageStorageManger {

    private String baseUrlPath;

    public String putImage(MultipartFile image) {
        return null;
    }

    public MultipartFile getImage(String imageDestination) {
        return null;
    }
}
