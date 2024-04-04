package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="allergiesmaster")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesMasterModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long allergyid;

    private String allergyname;
    private String allergycode;
    private Integer status;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "allergytype" ,referencedColumnName = "lookupid")
    private LookUpModel allergytype;

	public Long getAllergyid() {
		return allergyid;
	}

	public void setAllergyid(Long allergyid) {
		this.allergyid = allergyid;
	}

	public String getAllergyname() {
		return allergyname;
	}

	public void setAllergyname(String allergyname) {
		this.allergyname = allergyname;
	}

	public String getAllergycode() {
		return allergycode;
	}

	public void setAllergycode(String allergycode) {
		this.allergycode = allergycode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LookUpModel getAllergytype() {
		return allergytype;
	}

	public void setAllergytype(LookUpModel allergytype) {
		this.allergytype = allergytype;
	}
    
    

}
