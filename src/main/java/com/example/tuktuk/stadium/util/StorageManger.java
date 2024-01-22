package com.example.tuktuk.stadium.util;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Component
public abstract class StorageManger {
    private final String storageDestination = System.getenv("LOCAL_STORAGE");

    public String put(MultipartFile image){ return null; }

    public MultipartFile get(String imageDestination){ return null; }
}
