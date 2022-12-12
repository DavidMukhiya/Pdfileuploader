package com.david.fileuploader.Entity;


import javax.persistence.*;

@Entity
public class PdfFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @Lob
    private byte[] data;

    // Constructor, getters, and setters

    public PdfFile() {
    }

    public PdfFile(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public PdfFile(Long id, String fileName, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
