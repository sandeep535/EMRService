package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="visit_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDetailsModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitid;
    private Date visitdate;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "doctor" ,referencedColumnName = "id")
    private EmployeeModel doctor;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "visittype" ,referencedColumnName = "lookupid")
    private LookUpModel visittype;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "specilaity" ,referencedColumnName = "lookupid")
    private LookUpModel specilaity;

    private Float visitdiscount;
    private Float visittotalamount;
    private Float visitpercentage;
    private String reason;
    private Integer status;
    private Integer token;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "clientid" ,referencedColumnName = "seqid")
    private RegistrationModel clientid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitid")
    private Set<VisitServicesModel> services;

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

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
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
    
    
}
