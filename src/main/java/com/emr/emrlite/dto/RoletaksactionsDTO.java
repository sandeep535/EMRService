package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoletaksactionsDTO {
    private Long roletaskactionid;
    private Long taskid;
    private Long roleid;
    private Integer status;
    private Boolean ispermission;
    private Boolean defaultoption;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getIspermission() {
		return ispermission;
	}
	public void setIspermission(Boolean ispermission) {
		this.ispermission = ispermission;
	}
	public Boolean getDefaultoption() {
		return defaultoption;
	}
	public void setDefaultoption(Boolean defaultoption) {
		this.defaultoption = defaultoption;
	}
	public Boolean getDefaultoptionvalue() {
		return defaultoptionvalue;
	}
	public void setDefaultoptionvalue(Boolean defaultoptionvalue) {
		this.defaultoptionvalue = defaultoptionvalue;
	}
    
    
}
