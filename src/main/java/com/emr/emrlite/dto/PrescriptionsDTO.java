package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionsDTO {
    Long prescriptionid;
    Long drugid;
    String drugname;
    String dose;
    String doseunit;
    String sig;
    Date startdate;
    Date endate;
    String instructions;
    Integer status;
    Long clientid;
    Long visitid;
    Long capturedby;
	public Long getPrescriptionid() {
		return prescriptionid;
	}
	public void setPrescriptionid(Long prescriptionid) {
		this.prescriptionid = prescriptionid;
	}
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
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getDoseunit() {
		return doseunit;
	}
	public void setDoseunit(String doseunit) {
		this.doseunit = doseunit;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEndate() {
		return endate;
	}
	public void setEndate(Date endate) {
		this.endate = endate;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Long getCapturedby() {
		return capturedby;
	}
	public void setCapturedby(Long capturedby) {
		this.capturedby = capturedby;
	}
    
    
}
