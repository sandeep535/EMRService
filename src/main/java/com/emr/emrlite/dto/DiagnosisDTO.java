package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisDTO {
    Long diagnosisid;
    String description;
    Long clientid;
    Long visitid;
    Integer status;
}
