package com.emr.emrlite.controller;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.dto.VisitServicesDTO;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.service.RegistrationService;
import com.emr.emrlite.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(
        origins = {
                "http://localhost:3000",
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
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

    @GetMapping("/getVisits/{fromdate}/{todate}/{pageNumber}/{pageSize}")
    public List<VisitDetailsDTO> getVisits(@PathVariable("fromdate") Date fromdate, @PathVariable("todate") Date todate, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<VisitDetailsDTO> result = visitService.getVisists(fromdate,todate,pageNumber,pageSize);
        return result;
    }

    @GetMapping("/updateVisitStatus/{visitid}/{visitstatusid}")
    public Integer updateVisitStatus(@PathVariable("visitid") Long visitid,@PathVariable("visitstatusid") Integer visitstatusid) {
        Integer result = visitService.updateVisitStatus(visitid,visitstatusid);
        return result;
    }
}
