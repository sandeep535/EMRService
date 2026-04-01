package com.emr.emrlite.controller;

import com.emr.emrlite.dto.PatientDischargeDTO;
import com.emr.emrlite.service.PatientDischargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
        RequestMethod.POST })
@RestController
@RequestMapping("/api/discharge")
public class PatientDischargeController {

    @Autowired
    private PatientDischargeService service;

    @PostMapping("/save")
    public PatientDischargeDTO save(@RequestBody PatientDischargeDTO dto) {
        return service.saveDischarge(dto);
    }

    @GetMapping("/patient/{patientId}")
    public List<PatientDischargeDTO> getByPatient(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }

    @GetMapping("/visit/{visitId}")
    public PatientDischargeDTO getByVisit(@PathVariable Long visitId) {
        return service.getByVisitId(visitId);
    }
}
