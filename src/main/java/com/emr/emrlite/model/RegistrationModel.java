package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EMR_Registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seqid;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "title" ,referencedColumnName = "lookupid")
    private LookUpModel title;

    private String firstname;
    private String lastname;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "gender" ,referencedColumnName = "lookupid")
    private LookUpModel gender;

    private String contact;
    private String email;
    private String dob;
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address" ,referencedColumnName = "addressid")
    private AddressModel address;


}
