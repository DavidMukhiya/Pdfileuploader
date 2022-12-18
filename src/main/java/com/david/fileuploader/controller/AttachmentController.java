 package com.david.fileuploader.controller;

 import com.david.fileuploader.entity.Attachment;
 import com.david.fileuploader.model.ResponseData;
 import com.david.fileuploader.service.AttachmentService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.core.io.Resource;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.multipart.MultipartFile;
 import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 @RestController
public class AttachmentController {
     @Autowired
     private AttachmentService attachmentService;

     public AttachmentController(AttachmentService attachmentService) {
         this.attachmentService = attachmentService;
     }

     public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
         Attachment attachment = null;
         String downloadURL = "";
         attachment = attachmentService.saveAttachment(file);
         downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                 .path("/download/")
                 .path(attachment.getId())
                 .toUriString();

         return new ResponseData((attachment.getFileName(),
                 downloadURL,
                 file.getContentType(),
                 file.getSize());
     }

 }
