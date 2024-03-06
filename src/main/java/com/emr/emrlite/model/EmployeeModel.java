package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="employee_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer empid;
    private String firstname;
    private String lastname;
    private String username;
    private  String password;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "title" ,referencedColumnName = "lookupid")
    private LookUpModel title;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "designation" ,referencedColumnName = "lookupid")
    private LookUpModel designation;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "gender" ,referencedColumnName = "lookupid")
    private LookUpModel gender;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "role" ,referencedColumnName = "id")
    private MasterDataModel role;

    private Integer age;
    private Date dob;
    private String mail;
    private String mobilenumber;
}
