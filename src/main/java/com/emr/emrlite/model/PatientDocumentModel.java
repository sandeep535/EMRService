package com.emr.emrlite.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDocumentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "doc_type_id", nullable = false)
    private Long docTypeId;

    @Column(name = "doc_name", nullable = false)
    private String docName;

    @Column(name = "description")
    private String description;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
