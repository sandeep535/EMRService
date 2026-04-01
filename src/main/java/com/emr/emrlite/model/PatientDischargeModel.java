package com.emr.emrlite.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient_discharge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDischargeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "discharge_date", nullable = false)
    private LocalDateTime dischargeDate;

    @Column(name = "discharge_by_doctor_id")
    private Long dischargeByDoctorId;

    @Column(name = "discharge_by")
    private Long dischargeBy;

    @Column(name = "discharge_remarks")
    private String dischargeRemarks;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
