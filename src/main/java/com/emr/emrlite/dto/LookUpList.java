package com.emr.emrlite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookUpList {
    private List<LookUpDTO> key;

	public List<LookUpDTO> getKey() {
		return key;
	}

	public void setKey(List<LookUpDTO> key) {
		this.key = key;
	}
    
    
}
