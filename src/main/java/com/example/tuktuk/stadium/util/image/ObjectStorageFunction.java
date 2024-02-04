package com.example.tuktuk.stadium.util.image;

import org.springframework.web.multipart.MultipartFile;


public interface ObjectStorageFunction {
  public String putObject(MultipartFile file);

  public String getObject(String objectName);

  public String updateObject(String objectURL, MultipartFile file);
}
