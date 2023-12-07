package com.emr.emrlite.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="specilaity_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecilaityMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specilaityid;

    private String specilaityname;
    private Integer status;
}
