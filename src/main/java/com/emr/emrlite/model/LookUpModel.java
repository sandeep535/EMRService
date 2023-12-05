package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="lookup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LookUpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lookupid;
    private String lookupcode;
    private String lookupvalue;
    private String lookuptype;
}
