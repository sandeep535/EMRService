package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long countryid;
    String countryname;
    Integer status;
}
