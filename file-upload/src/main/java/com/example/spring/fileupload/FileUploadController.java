package com.example.spring.fileupload;

import org.apache.tomcat.jni.File;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {

    private final String fileBaseDirector="d:\\test\\";
    private final Path fileBasePath;

    public FileUploadController(){
        this.fileBasePath = Path.of(fileBaseDirector);
    }

    @GetMapping("/loadAll")
    public ResponseEntity loadAll() throws IOException {
        List<String> urlAll = Files.walk(fileBasePath,1).filter(path -> !path.equals(fileBasePath))
                .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,"loadFile",path.getFileName().toString())
                .build().toString())
                .collect(Collectors.toList());
        return ResponseEntity.ok(urlAll);

    }


    @DeleteMapping("/{fileName}")
    public ResponseEntity deleteFile(@PathVariable String fileName){
        Path deletePath = fileBasePath.resolve(fileName);
        Boolean isDelete = Boolean.FALSE;
        try {
            isDelete = FileSystemUtils.deleteRecursively(deletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(isDelete);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity loadFile(@PathVariable String fileName){
        Path path = fileBasePath.resolve(fileName);
        Resource  resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+resource.getFilename()+"\"")
                .body(resource);
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Path.of(fileBaseDirector + fileName);
        try {
            Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("OK");
    }





}
