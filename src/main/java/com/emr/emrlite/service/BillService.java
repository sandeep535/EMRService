package com.emr.emrlite.service;

import java.util.List;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.model.BillModel;

public interface BillService {
	
	Long generateBill(BillGenerationDTO billGenerationDTO);

	List<BillModel> getBills(Long visitId);

}
