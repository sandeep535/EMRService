package com.emr.emrlite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesAndTaskResponseModel  {
    @Id
    private Long taskid;
    private Long roletaskactionid;
    private Long roleid;
    private String screenname;
    private String screencode;
    private String actionname;
    private String actioncode;
    private Integer ispermission;
    private Integer status;
    private Boolean defultoption;
    private Boolean defaultoptionvalue;
}
