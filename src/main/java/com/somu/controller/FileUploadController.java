package com.somu.controller;

import com.somu.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileUploadHelper helper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
    {

        if (file.isEmpty())
            return new ResponseEntity<>("No File Selected...", HttpStatus.BAD_REQUEST);

        boolean flag = helper.uploadFile(file);

        if (flag)
        {
            return new ResponseEntity<>("File Upload Successfully...", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No File Selected...", HttpStatus.BAD_REQUEST);
        }

    }
}
