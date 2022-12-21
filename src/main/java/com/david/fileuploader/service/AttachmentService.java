package com.david.fileuploader.service;

import com.david.fileuploader.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    public Attachment saveAttachment(MultipartFile file) throws Exception;
    public Attachment getAttachment(String fileId) throws Exception;

}
