package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="vitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VitalsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

