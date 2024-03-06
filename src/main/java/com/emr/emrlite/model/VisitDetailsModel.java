package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="visit_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDetailsModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitid;
    private Date visitdate;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "doctor" ,referencedColumnName = "id")
    private EmployeeModel doctor;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "visittype" ,referencedColumnName = "lookupid")
    private LookUpModel visittype;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specilaity" ,referencedColumnName = "specilaityid")
    private SpecilaityMasterModel specilaity;

    private Float visitdiscount;
    private Float visittotalamount;
    private String reason;
    private Integer status;
    private Integer token;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "clientid" ,referencedColumnName = "seqid")
    private RegistrationModel clientid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitid")
    private Set<VisitServicesModel> services;
}
