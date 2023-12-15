package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="states")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stateid;
    private String statename;
    private String statecode;
    private Long countryid;
    private Integer status;
}
