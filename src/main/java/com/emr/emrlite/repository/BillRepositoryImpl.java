package com.emr.emrlite.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.emrlite.dto.BillViewDTO;
import com.emr.emrlite.model.BillModel;
import com.emr.emrlite.model.VisitServicesModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BillRepositoryImpl implements BillRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Long saveBill(BillModel bill) {
		entityManager.persist(bill);
		return bill.getBillId();

	}

	@Override
	public List<BillViewDTO> getBillsByVisitId(Long visitId) {

		List<BillViewDTO> bills = new ArrayList<>();
		Query query = entityManager.createQuery("select bill from BillModel bill where bill.visitid=:visitid",
				BillModel.class);
		query.setParameter("visitid", visitId);
		List<BillModel> results = query.getResultList();

		for (BillModel b : results) {
			BillViewDTO bill = new BillViewDTO();
			bill.setBillId(b.getBillId());
			bill.setBillNumber(b.getBillNumber());
			bill.setBillAmount(b.getBillAmount());
			bill.setBillDate(b.getBillDate());
			bill.setVisitid(b.getVisitid());
			bill.setVisitDiscount(b.getVisitDiscount());
			bill.setVisitDiscountPercentage(b.getVisitDiscountPercentage());
			bill.setBillAmountBeforeDiscount(b.getBillAmount() + b.getVisitDiscount());

			Query query1 = entityManager.createQuery("select vs from VisitServicesModel vs where vs.billId=:billId",
					VisitServicesModel.class);
			query1.setParameter("billId", b.getBillId());

			List<VisitServicesModel> services = query1.getResultList();
			bill.setServices(services);

			bills.add(bill);

		}

		return bills;
	}

}
