package com.emr.emrlite.repositoryImpl;

import com.emr.emrlite.model.AllergiesMasterModel;
import com.emr.emrlite.repository.AllergiesMasterReposiroty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AllerigiesMasterRepositoryImpl implements AllergiesMasterReposiroty {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<AllergiesMasterModel> findAllAllergies(AllergiesMasterModel allergiesMasterModel){
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

        TypedQuery<AllergiesMasterModel> query = entityManager.createQuery(cq);
        return query.getResultList();
   // entityManager.merge();
    }


    public AllergiesMasterModel saveAllergyMaster(AllergiesMasterModel allergiesMasterModel){
        entityManager.merge(allergiesMasterModel);
        AllergiesMasterModel allergiesMasterModel1 = new AllergiesMasterModel();
        allergiesMasterModel1.setAllergyid(allergiesMasterModel1.getAllergyid());
        return allergiesMasterModel1;
    }


}
