package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="masterdata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MasterDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mastercode;
    private String masterdatavalue;
    private Integer active;

}
