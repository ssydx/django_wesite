package com.springboot.myblog.controller;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.myblog.service.FileStorageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final FileStorageService fileStorageService;

    @GetMapping("/")
    public String uploadpage() {
        return "uploadpage";
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        fileStorageService.uploadFile(file);
        return "uploadpage";
    }
    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> download(@PathVariable String fileName,HttpServletRequest request) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"完善中");
    }
}
