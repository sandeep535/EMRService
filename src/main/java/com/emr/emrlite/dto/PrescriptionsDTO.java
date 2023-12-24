package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionsDTO {
    Long prescriptionid;
    Long drugid;
    String drugname;
    String dose;
    String doseunit;
    String sig;
    Date startdate;
    Date endate;
    String instructions;
    Integer status;
    Long clientid;
    Long visitid;
    Long capturedby;
}
