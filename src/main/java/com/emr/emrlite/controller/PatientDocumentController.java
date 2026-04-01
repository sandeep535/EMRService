package com.emr.emrlite.controller;

import com.emr.emrlite.dto.PatientDocumentDTO;
import com.emr.emrlite.model.PatientDocumentModel;
import com.emr.emrlite.service.PatientDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
        RequestMethod.POST, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/documents")
public class PatientDocumentController {

    @Autowired
    private PatientDocumentService service;

    @PostMapping("/upload")
    public PatientDocumentModel upload(@ModelAttribute PatientDocumentDTO dto) throws Exception {
        return service.uploadDocument(dto);
    }

    @GetMapping("/patient/{patientId}")
    public List<PatientDocumentDTO> getByPatient(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }

    @GetMapping("/visit/{visitId}")
    public List<PatientDocumentDTO> getByVisit(@PathVariable Long visitId) {
        return service.getByVisitId(visitId);
    }

    @GetMapping("/patient/{patientId}/type/{docTypeId}")
    public List<PatientDocumentDTO> getByPatientAndType(@PathVariable Long patientId, @PathVariable Long docTypeId) {
        return service.getByPatientAndType(patientId, docTypeId);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) throws Exception {
        byte[] data = service.downloadDocument(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"document\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }
}
