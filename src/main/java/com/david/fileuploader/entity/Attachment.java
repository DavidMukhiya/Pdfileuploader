package com.david.fileuploader.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
@NoArgsConstructor
public class Attachment {
//    The @GeneratedValue and @GenericGenerator annotations in this code are used to generate a unique identifier for the id field of the entity class.
//
//    The @GeneratedValue annotation is used to specify that the id field should be generated automatically by the database. It takes a generator attribute, which specifies the name of the generator to use for generating the value.
//
//    The @GenericGenerator annotation is used to define a generator for the id field. It takes a name attribute, which specifies the name of the generator, and a strategy attribute, which specifies the strategy to use for generating the value. In this case, the strategy being used is "uuid2", which generates a universally unique identifier (UUID) using the version 2 algorithm.

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}
