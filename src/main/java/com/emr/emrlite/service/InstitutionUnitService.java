package com.emr.emrlite.service;

import com.emr.emrlite.dto.InstitutionUnitDTO;
import com.emr.emrlite.model.IntistiutionsMasterModel;
import com.emr.emrlite.repository.InstitutionUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionUnitService {

    private final InstitutionUnitRepository repository;

    public InstitutionUnitService(InstitutionUnitRepository repository) {
        this.repository = repository;
    }

    public IntistiutionsMasterModel saveUnit(InstitutionUnitDTO dto) {
    	 IntistiutionsMasterModel unit = new IntistiutionsMasterModel();
    	    unit.setName(dto.getName());
    	    unit.setCode(dto.getCode());
    	    unit.setIsBed(dto.getIsBed());
    	    unit.setBedCost(dto.getBedCost());
    	    unit.setIsOccupied(false);

    	    if (dto.getParentId() != null) {
    	        IntistiutionsMasterModel parent = repository.findById(dto.getParentId())
    	                .orElseThrow(() -> new RuntimeException("Parent not found"));
    	        unit.setParent(parent);
    	    }

    	    return repository.save(unit);
    }

    public List<IntistiutionsMasterModel> getChildren(Long parentId) {
    	System.out.print(parentId);
    	if (parentId == -999) {
            return repository.findByParentIsNull();
        }
        return repository.findByParent_Id(parentId);
    }

    public List<IntistiutionsMasterModel> getAll() {
        return repository.findAll();
    }
}