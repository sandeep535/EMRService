package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalsDTO {
    Long vitalid;
    Long visitid;
    Long clientid;
    Float height;
    Float weight;
    Float bmi;
    Float systolic;
    Float diastolic;
    Float pulse;
    Float respiratoryrate;
    Float temperature;
    Long capturedby;
}
