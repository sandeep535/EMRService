package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="drugs_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugsMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long drugid;
    String drugname;
    Integer status;
    String drugcode;
}
