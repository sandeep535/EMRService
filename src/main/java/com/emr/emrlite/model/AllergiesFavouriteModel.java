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
@Table(name="allergiesfavourite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesFavouriteModel {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long allergiesfavouriteid;
	 
		@OneToOne(cascade = CascadeType.DETACH)
	    @JoinColumn(name = "allergyid" ,referencedColumnName = "allergyid")
	    private AllergiesMasterModel allergyid;
		
		private Long doctorid;
		private Integer active;
		public Long getAllergiesfavouriteid() {
			return allergiesfavouriteid;
		}
		public void setAllergiesfavouriteid(Long allergiesfavouriteid) {
			this.allergiesfavouriteid = allergiesfavouriteid;
		}
		public AllergiesMasterModel getAllergyid() {
			return allergyid;
		}
		public void setAllergyid(AllergiesMasterModel allergyid) {
			this.allergyid = allergyid;
		}
		public Long getDoctorid() {
			return doctorid;
		}
		public void setDoctorid(Long doctorid) {
			this.doctorid = doctorid;
		}
		public Integer getActive() {
			return active;
		}
		public void setActive(Integer active) {
			this.active = active;
		}
		
		
}
