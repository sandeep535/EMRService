package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookUpDTO {
    private Long lookupid;
    private String lookupcode;
    private String lookupvalue;
    private String lookuptype;
	public Long getLookupid() {
		return lookupid;
	}
	public void setLookupid(Long lookupid) {
		this.lookupid = lookupid;
	}
	public String getLookupcode() {
		return lookupcode;
	}
	public void setLookupcode(String lookupcode) {
		this.lookupcode = lookupcode;
	}
	public String getLookupvalue() {
		return lookupvalue;
	}
	public void setLookupvalue(String lookupvalue) {
		this.lookupvalue = lookupvalue;
	}
	public String getLookuptype() {
		return lookuptype;
	}
	public void setLookuptype(String lookuptype) {
		this.lookuptype = lookuptype;
	}
    
    
}
