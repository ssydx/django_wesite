package com.springboot.myblog.controller;

import java.io.IOException;
import org.springframework.http.HttpHeaders;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.myblog.service.FileStorageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final FileStorageService fileStorageService;

    // @GetMapping("/")
    // public String uploadpage() {
    //     return "uploadpage";
    // }
    @PostMapping
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return String.format("/file/%s", fileStorageService.uploadFile(file));
    }
    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> download(@PathVariable String fileName,HttpServletRequest request) {
        Resource ret;
        try {
            ret = fileStorageService.loadFile(fileName);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "文件不存在");
        }
        return downLoadFile(ret,request);
    }
    private ResponseEntity<Resource> downLoadFile(Resource resource,HttpServletRequest request) {
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            log.error("没有此类型");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename()).body(resource);
    }
}
