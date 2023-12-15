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
    private String address1;
    private String address2;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "country" ,referencedColumnName = "countryid")
    private CountriesModel country;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "state" ,referencedColumnName = "stateid")
    private StateModel state;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "city" ,referencedColumnName = "cityid")
    private CityModel city;

    private Integer pincode;
}
