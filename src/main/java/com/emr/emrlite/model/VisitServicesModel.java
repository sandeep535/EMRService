package com.emr.emrlite.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="visit_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitServicesModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long visitid;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "serviceid" ,referencedColumnName = "serviceid")
    private ServiceMasterModel serviceid;

    private Float serviceprice;
    private Float servicediscount;
    private Float quantity;
    private Float servicetotalamount;
    private Integer status;

}
