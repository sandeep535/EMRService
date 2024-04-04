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
    private Boolean defaultoptionvalue;
	public Long getRoletaskactionid() {
		return roletaskactionid;
	}
	public void setRoletaskactionid(Long roletaskactionid) {
		this.roletaskactionid = roletaskactionid;
	}
	public Long getTaskid() {
		return taskid;
	}
	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public Boolean getIspermission() {
		return ispermission;
	}
	public void setIspermission(Boolean ispermission) {
		this.ispermission = ispermission;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getDefaultoptionvalue() {
		return defaultoptionvalue;
	}
	public void setDefaultoptionvalue(Boolean defaultoptionvalue) {
		this.defaultoptionvalue = defaultoptionvalue;
	}
    
    
}
