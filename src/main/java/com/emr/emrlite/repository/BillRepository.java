package com.emr.emrlite.repository;

import java.util.List;
import java.util.Optional;

import com.emr.emrlite.dto.BillViewDTO;
import com.emr.emrlite.model.BillModel;

public interface BillRepository {

	Long saveBill(BillModel bill);

	List<BillViewDTO> getBillsByVisitId(Long visitId);

	BillModel findByBillId(Long billId);

}
