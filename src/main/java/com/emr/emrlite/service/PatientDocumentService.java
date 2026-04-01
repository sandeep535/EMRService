package com.emr.emrlite.service;

import com.emr.emrlite.dto.PatientDocumentDTO;
import com.emr.emrlite.model.MasterDataModel;
import com.emr.emrlite.model.PatientDocumentModel;
import com.emr.emrlite.repository.MasterDataRepository;
import com.emr.emrlite.repository.PatientDocumentRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PatientDocumentService {

    private final PatientDocumentRepository repository;
    private final MasterDataRepository masterDataRepository;

    @Value("${app.upload.dir:uploads}")
    private String uploadDir;

    public PatientDocumentService(PatientDocumentRepository repository, MasterDataRepository masterDataRepository) {
        this.repository = repository;
        this.masterDataRepository = masterDataRepository;
    }

    public PatientDocumentModel uploadDocument(PatientDocumentDTO dto) throws Exception {
        String date = LocalDate.now().toString();
        String uniqueFileName = UUID.randomUUID() + "_" + dto.getFile().getOriginalFilename();
        String relativePath = dto.getPatientId() + "/" + dto.getDocTypeId() + "/" + date + "/" + uniqueFileName;
        String fullPath = uploadDir + "/" + relativePath;

        File dest = new File(fullPath);
        dest.getParentFile().mkdirs();
        Files.write(Paths.get(fullPath), dto.getFile().getBytes());

        PatientDocumentModel doc = PatientDocumentModel.builder()
                .patientId(dto.getPatientId())
                .visitId(dto.getVisitId())
                .docTypeId(dto.getDocTypeId())
                .docName(dto.getDocName())
                .description(dto.getDescription())
                .filePath(relativePath)
                .fileName(dto.getFile().getOriginalFilename())
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(doc);
    }

    private PatientDocumentDTO toDTO(PatientDocumentModel doc) {
        PatientDocumentDTO dto = new PatientDocumentDTO();
        dto.setId(doc.getId());
        dto.setPatientId(doc.getPatientId());
        dto.setVisitId(doc.getVisitId());
        dto.setDocTypeId(doc.getDocTypeId());
        dto.setDocName(doc.getDocName());
        dto.setDescription(doc.getDescription());
        dto.setFilePath(doc.getFilePath());
        dto.setFileName(doc.getFileName());
        dto.setCreatedAt(doc.getCreatedAt());
        masterDataRepository.findById(doc.getDocTypeId()).ifPresent(m -> dto.setDocTypeName(m.getMasterdatavalue()));
        return dto;
    }

    public List<PatientDocumentDTO> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId).stream().map(this::toDTO).collect(java.util.stream.Collectors.toList());
    }

    public List<PatientDocumentDTO> getByVisitId(Long visitId) {
        return repository.findByVisitId(visitId).stream().map(this::toDTO).collect(java.util.stream.Collectors.toList());
    }

    public List<PatientDocumentDTO> getByPatientAndType(Long patientId, Long docTypeId) {
        return repository.findByPatientIdAndDocTypeId(patientId, docTypeId).stream().map(this::toDTO).collect(java.util.stream.Collectors.toList());
    }

    public byte[] downloadDocument(Long id) throws Exception {
        PatientDocumentModel doc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        return Files.readAllBytes(Paths.get(uploadDir + "/" + doc.getFilePath()));
    }
}
