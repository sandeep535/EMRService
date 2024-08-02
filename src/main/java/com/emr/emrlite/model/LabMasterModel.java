package com.emr.emrlite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="labmaster")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabMasterModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long labid;

    private String labname;
    private Integer status;
	public Long getLabid() {
		return labid;
	}
	public void setLabid(Long labid) {
		this.labid = labid;
	}
	public String getLabname() {
		return labname;
	}
	public void setLabname(String labname) {
		this.labname = labname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
