package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emr_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressid;
    private Integer city;
    private Integer country;
    private String address1;
    private String address2;


}
