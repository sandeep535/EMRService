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
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drugtype" ,referencedColumnName = "id")
    private MasterDataModel drugtype;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drugalert" ,referencedColumnName = "id")
    private MasterDataModel drugalert;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drugform" ,referencedColumnName = "id")
    private MasterDataModel drugform;
    
    String drugdose;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drugunit" ,referencedColumnName = "id")
    private MasterDataModel drugunit;
    
    
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
	public MasterDataModel getDrugtype() {
		return drugtype;
	}
	public void setDrugtype(MasterDataModel drugtype) {
		this.drugtype = drugtype;
	}
	public MasterDataModel getDrugalert() {
		return drugalert;
	}
	public void setDrugalert(MasterDataModel drugalert) {
		this.drugalert = drugalert;
	}
	public MasterDataModel getDrugform() {
		return drugform;
	}
	public void setDrugform(MasterDataModel drugform) {
		this.drugform = drugform;
	}
	public String getDrugdose() {
		return drugdose;
	}
	public void setDrugdose(String drugdose) {
		this.drugdose = drugdose;
	}
	public MasterDataModel getDrugunit() {
		return drugunit;
	}
	public void setDrugunit(MasterDataModel drugunit) {
		this.drugunit = drugunit;
	}
    
	
    
}
