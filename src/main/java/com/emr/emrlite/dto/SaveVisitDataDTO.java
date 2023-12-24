package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveVisitDataDTO {
    Long clientid;
    Long visitid;
    Long capturedby;
    List<PrescriptionsDTO> prescriptions;
    VitalsDTO vitalsDTO;
    NotesDTO notesDTO;
    DiagnosisDTO diagnosisDTO;

}
