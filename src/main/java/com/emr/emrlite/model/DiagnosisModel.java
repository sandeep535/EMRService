package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emr_diagnosis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long diagnosisid;
    String description;
    Long clientid;
    Long visitid;
    Integer status;

}
