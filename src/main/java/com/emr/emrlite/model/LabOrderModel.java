package com.emr.emrlite.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="laborders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabOrderModel extends BaseEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long labtransid;

    private String labname;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "labmasterid" ,referencedColumnName = "labid")
    private LabMasterModel labmasterid;
    
    private Integer status;
    
    private Long visitid;
    private Long clientid;

	public Long getLabtransid() {
		return labtransid;
	}

	public void setLabtransid(Long labtransid) {
		this.labtransid = labtransid;
	}

	public String getLabname() {
		return labname;
	}

	public void setLabname(String labname) {
		this.labname = labname;
	}

	public LabMasterModel getLabmasterid() {
		return labmasterid;
	}

	public void setLabmasterid(LabMasterModel labmasterid) {
		this.labmasterid = labmasterid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getVisitid() {
		return visitid;
	}

	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
    
    
}
