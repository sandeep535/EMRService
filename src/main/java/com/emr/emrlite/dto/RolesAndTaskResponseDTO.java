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
	public Long getTaskid() {
		return taskid;
	}
	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public Long getRoletaskactionid() {
		return roletaskactionid;
	}
	public void setRoletaskactionid(Long roletaskactionid) {
		this.roletaskactionid = roletaskactionid;
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
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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
    
    
}
