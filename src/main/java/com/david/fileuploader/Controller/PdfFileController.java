package com.david.fileuploader.Controller;

import com.david.fileuploader.Entity.PdfFile;
import com.david.fileuploader.Repository.PdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PdfFileController {
    @Autowired
    private PdfFileRepository pdfFileRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        // Check that the file is a PDF
        if (!file.getContentType().equals("application/pdf")) {
            return ResponseEntity.badRequest().body("Invalid file type. Only PDF files are allowed.");
        }

        // Save the file to the database
        PdfFile savedFile = pdfFileRepository.save(new PdfFile(file.getOriginalFilename(), file.getBytes()));

        // Return a response with the file's ID
        return ResponseEntity.ok(savedFile.getId()+"");
    }
}

