package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer empid;
    private String firstname;
    private String lastname;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "title" ,referencedColumnName = "lookupid")
    private LookUpModel title;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "designation" ,referencedColumnName = "lookupid")
    private LookUpModel designation;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "gender" ,referencedColumnName = "lookupid")
    private LookUpModel gender;
}
