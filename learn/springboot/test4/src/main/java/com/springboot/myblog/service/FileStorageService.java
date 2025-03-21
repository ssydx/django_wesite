package com.springboot.myblog.service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.myblog.config.FileStorageProperties;

@Service
public class FileStorageService {
    private final Path fileStorageLocation;
    public FileStorageService(FileStorageProperties fileStorageProperties) throws Exception {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        System.out.println(fileStorageLocation);
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("无法找到此目录", e);
        }
    }
    public String uploadFile(MultipartFile file) {
        String originalName = file.getOriginalFilename();
        String extName = originalName == null || originalName.lastIndexOf(".") <=0 ? null:originalName.substring(originalName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extName;
        if (fileName.contains("..")) {
            throw new RuntimeException("文件名非法" + fileName);
        }
        Path target = fileStorageLocation.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("无法保存");
        }
        return fileName;
    }
    public Resource loadFile(String fileName) throws FileNotFoundException {
        Path filePath = fileStorageLocation.resolve(fileName).normalize();
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("文件未找到" + fileName);
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("文件未找到" + fileName);
        }
    }
}
