package com.emr.emrlite.dto;

import com.emr.emrlite.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VisitDetailsDTO {

    private Long visitid;
    private Date visitdate;
    private EmployeeModel doctor;
    private LookUpModel visittype;
    private LookUpModel specilaity;
    private Float visitdiscount;
    private Float visittotalamount;
    private Float visitpercentage;
    private String reason;
    private Integer status;
    private RegistrationModel clientid;
    private Set<VisitServicesModel> services;
    private Integer token;
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Date getVisitdate() {
		return visitdate;
	}
	public void setVisitdate(Date visitdate) {
		this.visitdate = visitdate;
	}
	public EmployeeModel getDoctor() {
		return doctor;
	}
	public void setDoctor(EmployeeModel doctor) {
		this.doctor = doctor;
	}
	public LookUpModel getVisittype() {
		return visittype;
	}
	public void setVisittype(LookUpModel visittype) {
		this.visittype = visittype;
	}
	public LookUpModel getSpecilaity() {
		return specilaity;
	}
	public void setSpecilaity(LookUpModel specilaity) {
		this.specilaity = specilaity;
	}
	public Float getVisitdiscount() {
		return visitdiscount;
	}
	public void setVisitdiscount(Float visitdiscount) {
		this.visitdiscount = visitdiscount;
	}
	public Float getVisittotalamount() {
		return visittotalamount;
	}
	public void setVisittotalamount(Float visittotalamount) {
		this.visittotalamount = visittotalamount;
	}
	public Float getVisitpercentage() {
		return visitpercentage;
	}
	public void setVisitpercentage(Float visitpercentage) {
		this.visitpercentage = visitpercentage;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public RegistrationModel getClientid() {
		return clientid;
	}
	public void setClientid(RegistrationModel clientid) {
		this.clientid = clientid;
	}
	public Set<VisitServicesModel> getServices() {
		return services;
	}
	public void setServices(Set<VisitServicesModel> services) {
		this.services = services;
	}
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}
    
    
}
