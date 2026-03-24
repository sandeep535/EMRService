package com.emr.emrlite.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bed_assignment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BedAssignmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bed_id", nullable = false)
    private Long bedId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "admitted_at", nullable = false)
    private LocalDateTime admittedAt;

    @Column(name = "discharged_at")
    private LocalDateTime dischargedAt;

    // 1=Active, 0=Discharged
    @Column(nullable = false)
    private Integer status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
