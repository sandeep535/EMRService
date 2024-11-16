package com.emr.emrlite.repository;

import java.util.List;

import com.emr.emrlite.model.BillModel;

public interface BillRepository {

	Long saveBill(BillModel bill);

	List<BillModel> getBillsByVisitId(Long visitId);

}
