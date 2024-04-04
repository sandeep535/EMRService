package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="drugs_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugsMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long drugid;
    String drugname;
    Integer status;
    String drugcode;
	public Long getDrugid() {
		return drugid;
	}
	public void setDrugid(Long drugid) {
		this.drugid = drugid;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDrugcode() {
		return drugcode;
	}
	public void setDrugcode(String drugcode) {
		this.drugcode = drugcode;
	}
    
    
}
