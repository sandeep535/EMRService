package com.emr.emrlite.controller;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.dto.VisitServicesDTO;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.service.RegistrationService;
import com.emr.emrlite.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit")
@RequiredArgsConstructor
public class VisistController {

    private final VisitService visitService;
    @PostMapping
    public VisitDetailsDTO saveVisit(@RequestBody VisitDetailsDTO visitDetailsDTO){
        VisitDetailsDTO result = visitService.saveVisit(visitDetailsDTO);
        return result;
    }

    @GetMapping("/getVisits/{pageNumber}/{pageSize}")
    public List<VisitDetailsDTO> getVisits(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<VisitDetailsDTO> result = visitService.getVisists(pageNumber,pageSize);
        return result;
    }
}
