package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="emr_prescriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionsModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
