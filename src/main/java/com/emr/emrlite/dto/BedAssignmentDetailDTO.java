package com.emr.emrlite.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BedAssignmentDetailDTO {
    private Long id;
    private Long bedId;
    private Long patientId;
    private LocalDateTime admittedAt;
    private LocalDateTime dischargedAt;
    private Integer status;
    private String bedPath; // e.g. Block1 > Room1 > Bed1
}
