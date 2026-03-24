package com.emr.emrlite.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BedAssignmentDTO {
    private Long bedId;
    private Long patientId;
    private LocalDateTime admittedAt;
    private LocalDateTime dischargedAt;
}
