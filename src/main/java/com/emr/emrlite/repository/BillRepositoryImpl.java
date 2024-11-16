package com.emr.emrlite.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.emrlite.model.BillModel;

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
	public List<BillModel> getBillsByVisitId(Long visitId) {
		Query query = entityManager.createQuery("select bill from BillModel bill where bill.visitid=:visitid");
		query.setParameter("visitid", visitId);
		return query.getResultList();
	}

}
