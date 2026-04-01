package com.emr.emrlite.repository;

import com.emr.emrlite.model.PatientDischargeModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDischargeRepository extends JpaRepository<PatientDischargeModel, Long> {
    List<PatientDischargeModel> findByPatientId(Long patientId);
    Optional<PatientDischargeModel> findByVisitId(Long visitId);
}
