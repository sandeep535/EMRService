package com.emr.emrlite.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.emr.emrlite.dto.LabMasterPaginationDTO;
import com.emr.emrlite.model.DiagnosisMasterModel;
import com.emr.emrlite.model.LabMasterModel;
import com.emr.emrlite.repository.LabMasterRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class LabMasterRepositoryImpl implements LabMasterRepository{
	@Autowired
    EntityManager entityManager;

	@Override
	public LabMasterModel saveDiagnosisMaster(LabMasterModel labMasterModel) {
		entityManager.merge(labMasterModel);
		 LabMasterModel labMasterModelRes = new LabMasterModel();
		 labMasterModelRes.setLabid(labMasterModel.getLabid());
	     return labMasterModelRes;
	}

	@Override
	public LabMasterPaginationDTO getLabMatser(LabMasterPaginationDTO labMasterPaginationDTO) {
		Pageable paging = PageRequest.of(labMasterPaginationDTO.getPagenumber(), labMasterPaginationDTO.getPagesize());
		  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		  CriteriaQuery<LabMasterModel> cq = cb.createQuery(LabMasterModel.class);
		  List<Predicate> predicates = new ArrayList<>();
		  Root<LabMasterModel> labMasterModelRoot = cq.from(LabMasterModel.class);
		  LabMasterModel request = labMasterPaginationDTO.getLabMasterModel().get(0);
		  predicates.add(cb.like(labMasterModelRoot.get("labname"), "%" + request.getLabname() + "%"));
		  if(request.getStatus() != -999) {
			  predicates.add(cb.and(cb.equal(labMasterModelRoot.get("status"), request.getStatus())));
		  }
		  cq.select(labMasterModelRoot).where(predicates.toArray(new Predicate[] {}));
		  List<LabMasterModel> result;
		  result = entityManager.createQuery(cq).setFirstResult((int) paging.getOffset()).setMaxResults(paging.getPageSize()).getResultList();
		  labMasterPaginationDTO.setLabMasterModel(result);
		  return labMasterPaginationDTO;
	}

}
