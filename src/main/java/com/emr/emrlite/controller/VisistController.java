package com.emr.emrlite.controller;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.dto.VisitServicesDTO;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.service.RegistrationService;
import com.emr.emrlite.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
