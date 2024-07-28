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
@Table(name="diagnosismaster")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisMasterModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dignosisid;

    private String dignosisname;
    private String dignosiscode;
    private Integer status;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "dignosiscodeset" ,referencedColumnName = "lookupid")
    private LookUpModel dignosiscodeset;

	public Long getDignosisid() {
		return dignosisid;
	}

	public void setDignosisid(Long dignosisid) {
		this.dignosisid = dignosisid;
	}

	public String getDignosisname() {
		return dignosisname;
	}

	public void setDignosisname(String dignosisname) {
		this.dignosisname = dignosisname;
	}

	public String getDignosiscode() {
		return dignosiscode;
	}

	public void setDignosiscode(String dignosiscode) {
		this.dignosiscode = dignosiscode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LookUpModel getDignosiscodeset() {
		return dignosiscodeset;
	}

	public void setDignosiscodeset(LookUpModel dignosiscodeset) {
		this.dignosiscodeset = dignosiscodeset;
	}
    
    

}
