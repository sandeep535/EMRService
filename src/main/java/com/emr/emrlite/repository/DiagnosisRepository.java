package com.emr.emrlite.repository;

import com.emr.emrlite.model.DiagnosisModel;
import com.emr.emrlite.model.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiagnosisRepository extends JpaRepository<DiagnosisModel,Long> {
    DiagnosisModel findDiagnosisModelByVisitid(Long visitid);
}
