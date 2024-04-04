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
	public Long getTaskid() {
		return taskid;
	}
	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}
	public Long getRoletaskactionid() {
		return roletaskactionid;
	}
	public void setRoletaskactionid(Long roletaskactionid) {
		this.roletaskactionid = roletaskactionid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getScreencode() {
		return screencode;
	}
	public void setScreencode(String screencode) {
		this.screencode = screencode;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getActioncode() {
		return actioncode;
	}
	public void setActioncode(String actioncode) {
		this.actioncode = actioncode;
	}
	public Integer getIspermission() {
		return ispermission;
	}
	public void setIspermission(Integer ispermission) {
		this.ispermission = ispermission;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getDefultoption() {
		return defultoption;
	}
	public void setDefultoption(Boolean defultoption) {
		this.defultoption = defultoption;
	}
	public Boolean getDefaultoptionvalue() {
		return defaultoptionvalue;
	}
	public void setDefaultoptionvalue(Boolean defaultoptionvalue) {
		this.defaultoptionvalue = defaultoptionvalue;
	}
    
    
}
