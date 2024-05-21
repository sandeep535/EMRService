package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="allergies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesModel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long allergyid;
    String allergy;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "allergymaster" ,referencedColumnName = "allergyid")
    private AllergiesMasterModel allergymaster;
    
    Integer status;
    String indications;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "severity" ,referencedColumnName = "lookupid")
    private LookUpModel severity;

    private Long visitid;
    private Long clientid;
	public Long getAllergyid() {
		return allergyid;
	}
	public void setAllergyid(Long allergyid) {
		this.allergyid = allergyid;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getIndications() {
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	public LookUpModel getSeverity() {
		return severity;
	}
	public void setSeverity(LookUpModel severity) {
		this.severity = severity;
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
	public AllergiesMasterModel getAllergymaster() {
		return allergymaster;
	}
	public void setAllergymaster(AllergiesMasterModel allergymaster) {
		this.allergymaster = allergymaster;
	}
	
    
    
}
