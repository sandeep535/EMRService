package com.emr.emrlite.service;

import java.util.List;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.dto.BillViewDTO;

public interface BillService {
	
	Long generateBill(BillGenerationDTO billGenerationDTO);

	List<BillViewDTO> getBills(Long visitId);

}
