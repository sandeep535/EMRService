package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="roletaksactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleTaksActionsModel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roletaskactionid;
    private Long taskid;
    private Long roleid;
    private Boolean ispermission;
    private Integer status;
}
