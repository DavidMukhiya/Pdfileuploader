package com.david.fileuploader.Repository;

import com.david.fileuploader.Entity.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfFileRepository extends JpaRepository<PdfFile, Long> {
}
