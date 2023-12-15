package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cityid;
    String cityname;
    String citycode;
    Long stateid;
    Integer status;
}
