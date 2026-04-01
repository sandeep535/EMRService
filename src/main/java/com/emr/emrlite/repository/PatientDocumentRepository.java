package com.emr.emrlite.repository;

import com.emr.emrlite.model.PatientDocumentModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDocumentRepository extends JpaRepository<PatientDocumentModel, Long> {
    List<PatientDocumentModel> findByPatientId(Long patientId);
    List<PatientDocumentModel> findByVisitId(Long visitId);
    List<PatientDocumentModel> findByPatientIdAndDocTypeId(Long patientId, Long docTypeId);
}
