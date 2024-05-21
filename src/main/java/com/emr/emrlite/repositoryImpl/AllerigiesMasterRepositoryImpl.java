package com.emr.emrlite.repositoryImpl;

import com.emr.emrlite.dto.AllergiesListPaginationDTO;
import com.emr.emrlite.dto.AllergiesRequestDTO;
import com.emr.emrlite.model.AllergiesMasterModel;
import com.emr.emrlite.model.AllergiesModel;
import com.emr.emrlite.repository.AllergiesMasterReposiroty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AllerigiesMasterRepositoryImpl implements AllergiesMasterReposiroty {
    @Autowired
    EntityManager entityManager;
    @Override
    public AllergiesListPaginationDTO findAllAllergies(AllergiesMasterModel allergiesMasterModel,Pageable pageable){
        List<AllergiesMasterModel> allergiesMasterModels = new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AllergiesMasterModel> cq = cb.createQuery(AllergiesMasterModel.class);
        List<Predicate> predicates = new ArrayList<>();
        Root<AllergiesMasterModel> allergiesMasterModelRoot = cq.from(AllergiesMasterModel.class);
        predicates.add(cb.like(allergiesMasterModelRoot.get("allergyname"), "%" + allergiesMasterModel.getAllergyname() + "%"));
        if(allergiesMasterModel.getAllergycode()!= null){
            predicates.add(cb.and(cb.like(allergiesMasterModelRoot.get("allergycode"), "%" + allergiesMasterModel.getAllergycode() + "%")));
        }
        if(allergiesMasterModel.getAllergytype()!= null){
            predicates.add(cb.and(cb.equal(allergiesMasterModelRoot.get("allergytype"), allergiesMasterModel.getAllergytype().getLookupid())));
        }
        if(allergiesMasterModel.getStatus()!= null){
            predicates.add(cb.and(cb.equal(allergiesMasterModelRoot.get("status"), allergiesMasterModel.getStatus())));
        }
        cq.select(allergiesMasterModelRoot).where(predicates.toArray(new Predicate[] {}));

        List<AllergiesMasterModel> result;
        result = entityManager.createQuery(cq).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        //entityManager.fect(result);
        
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);    
        Root<AllergiesMasterModel> allergiesCount = countQuery.from(AllergiesMasterModel.class);
        List<Predicate> predicates1 = new ArrayList<>();
        predicates1.add(cb.like(allergiesCount.get("allergyname"), "%" + allergiesMasterModel.getAllergyname() + "%"));
        if(allergiesMasterModel.getAllergycode()!= null){
        	predicates1.add(cb.and(cb.like(allergiesCount.get("allergycode"), "%" + allergiesMasterModel.getAllergycode() + "%")));
        }
        if(allergiesMasterModel.getAllergytype()!= null){
        	predicates1.add(cb.and(cb.equal(allergiesCount.get("allergytype"), allergiesMasterModel.getAllergytype().getLookupid())));
        }
        if(allergiesMasterModel.getStatus()!= null){
        	predicates1.add(cb.and(cb.equal(allergiesCount.get("status"), allergiesMasterModel.getStatus())));
        }
        
        countQuery.select(cb.count(allergiesCount)).where(predicates1.toArray(new Predicate[predicates1.size()]));
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        Page<AllergiesMasterModel> result1 = new PageImpl<>(result, pageable, count);
        AllergiesListPaginationDTO allergiesListPaginationDTO = new AllergiesListPaginationDTO();
        allergiesListPaginationDTO.setTotalcount(count);
        allergiesListPaginationDTO.setAllergieslist(result);
        return allergiesListPaginationDTO;
   // entityManager.merge();
    }


    public AllergiesMasterModel saveAllergyMaster(AllergiesMasterModel allergiesMasterModel){
        entityManager.merge(allergiesMasterModel);
        AllergiesMasterModel allergiesMasterModel1 = new AllergiesMasterModel();
        allergiesMasterModel1.setAllergyid(allergiesMasterModel1.getAllergyid());
        return allergiesMasterModel1;
    }

    public AllergiesRequestDTO findAllergiesfilter(AllergiesRequestDTO allergiesModel, Pageable page) {
		// TODO Auto-generated method stub
		  List<AllergiesModel> allergiesModel1 = new ArrayList<>();
		  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		  CriteriaQuery<AllergiesModel> cq = cb.createQuery(AllergiesModel.class);
		  List<Predicate> predicates = new ArrayList<>();
		  Root<AllergiesModel> allergiesModelRoot = cq.from(AllergiesModel.class);
		  
		  predicates.add(cb.like(allergiesModelRoot.get("allergy"), "%" + allergiesModel.getAllergy() + "%"));
		  if(allergiesModel.getStatus() != -999) {
			  predicates.add(cb.and(cb.equal(allergiesModelRoot.get("status"), allergiesModel.getStatus())));
		  }
		  if(allergiesModel.getClientid() != null) {
			  predicates.add(cb.and(cb.equal(allergiesModelRoot.get("clientid"), allergiesModel.getClientid())));
		  }
		  if(allergiesModel.getVisitid() != null) {
			  predicates.add(cb.and(cb.equal(allergiesModelRoot.get("visitid"), allergiesModel.getVisitid())));
		  }
		  if(allergiesModel.getSeverity() != null) {
			  predicates.add(cb.and(cb.equal(allergiesModelRoot.get("visitid"), allergiesModel.getVisitid())));
		  }
		  cq.select(allergiesModelRoot).where(predicates.toArray(new Predicate[] {}));
		  List<AllergiesModel> result;
	        result = entityManager.createQuery(cq).getResultList();
	        AllergiesRequestDTO allergiesRequestDTO = new AllergiesRequestDTO();
	        allergiesRequestDTO.setAllergieslist(result);
		return allergiesRequestDTO;
	}
    
    
    


}
