package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="allergies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesModel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long allergyid;
    String allergy;
    Integer status;
    String indications;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "severity" ,referencedColumnName = "lookupid")
    private LookUpModel severity;

    private Long visitid;
    private Long clientid;
}
