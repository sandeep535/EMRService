package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="service_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMasterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceid;
    private String servicename;
    private Float price;
    private Integer active;

}
