package com.emr.emrlite.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesAndTaskResponseDTO {

    private Long taskid;
    private String screenname;
    private Long roletaskactionid;
    private String screencode;
    private String actionname;
    private String actioncode;
    private Long roleid;
    private Integer ispermission;
    private Integer status;
}
