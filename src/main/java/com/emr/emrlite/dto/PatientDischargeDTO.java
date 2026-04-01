package com.emr.emrlite.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDischargeDTO {
    private Long id;
    private Long patientId;
    private Long visitId;
    private LocalDateTime dischargeDate;
    private Long dischargeByDoctorId;
    private String dischargeDoctorName;
    private Long dischargeBy;
    private String dischargeRemarks;
    private LocalDateTime createdAt;
}
