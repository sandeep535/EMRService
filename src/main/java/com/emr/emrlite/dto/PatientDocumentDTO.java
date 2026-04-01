package com.emr.emrlite.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDocumentDTO {
    private MultipartFile file;
    private Long patientId;
    private Long visitId;
    private Long docTypeId;
    private String docName;
    private String description;

    // response fields
    private Long id;
    private String docTypeName;
    private String filePath;
    private String fileName;
    private java.time.LocalDateTime createdAt;
}
