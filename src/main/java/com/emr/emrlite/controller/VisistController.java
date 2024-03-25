package com.emr.emrlite.controller;

import com.emr.emrlite.dto.*;
import com.emr.emrlite.model.AllergiesModel;
import com.emr.emrlite.model.DiagnosisModel;
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

    @GetMapping("/getVisits/{fromdate}/{todate}/{status}/{pageNumber}/{pageSize}")
    public List<VisitDetailsDTO> getVisits(@PathVariable("fromdate") Date fromdate, @PathVariable("todate") Date todate,@PathVariable("status") Integer status, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        List<VisitDetailsDTO> result = visitService.getVisists(fromdate,todate,status,pageNumber,pageSize);
        return result;
    }

    @GetMapping("/updateVisitStatus/{visitid}/{visitstatusid}")
    public Integer updateVisitStatus(@PathVariable("visitid") Long visitid,@PathVariable("visitstatusid") Integer visitstatusid) {
        Integer result = visitService.updateVisitStatus(visitid,visitstatusid);
        return result;
    }

    @GetMapping("/countBasedonVisitDate/{visitdate}")
    public Long countBasedonVisitDate(@PathVariable("visitdate") Date visitdate) {
        Long result = visitService.countBasedonVisitDate(visitdate);
        return result;
    }

    @PostMapping(value = "/vitals")
    public VitalsDTO saveVitals(@RequestBody VitalsDTO vitalsDTO){
        VitalsDTO result = visitService.saveVitals(vitalsDTO);
        return result;
    }

    @GetMapping("/getVitals/{visitid}/{clientid}")
    public List<VitalsDTO> getVitals(@PathVariable("visitid") Long visitid,@PathVariable("clientid") Long clientid){
        try{
            List<VitalsDTO> result = visitService.getVitals(visitid,clientid);
            return result;
        }catch (Exception error){
            System.out.println("vital exception-excepton----1"+error);
            List<VitalsDTO> result = null;
            return result;
        }

    }
    @PostMapping(value = "/notes")
    public NotesDTO saveNotes(@RequestBody NotesDTO notesDTO){
        NotesDTO result = visitService.saveNotes(notesDTO);
        return result;
    }
    @GetMapping("/getNotes/{visitid}")
    public NotesDTO getNotes(@PathVariable("visitid") Long visitid){
        NotesDTO result = visitService.getNotes(visitid);
        return result;
    }
    @PostMapping(value = "/saveDiagnosis")
    public DiagnosisDTO saveDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO){
        DiagnosisDTO result = visitService.saveDiagnosis(diagnosisDTO);
        return result;
    }

    @GetMapping("/getDiagnosis/{visitid}")
    public DiagnosisDTO getDiagnosis(@PathVariable("visitid") Long visitid){
        DiagnosisDTO result = visitService.getDiagnosis(visitid);
        return result;
    }
    @PostMapping(value = "/saveVisitData")
    public String saveVisitData(@RequestBody SaveVisitDataDTO saveVisitDataDTO){
        visitService.saveVisitData(saveVisitDataDTO);
        return "Saved";
    }

    @PostMapping(value = "/saveAllergies")
    public String saveAllergies(@RequestBody List<AllergiesModel> allergiesDTOSList){
        visitService.saveAllergies(allergiesDTOSList);
        return "Saved";
    }

    @GetMapping("/getAllergies/{visitid}/{clientid}")
    public List<AllergiesModel> getAllergies(@PathVariable("visitid") Long visitid,@PathVariable("clientid") Long clientid){
        try{
            List<AllergiesModel> result = visitService.getAllergies(visitid,clientid);
            return result;
        }catch (Exception error){
            System.out.println("vital exception-excepton----1"+error);
            List<AllergiesModel> result = null;
            return result;
        }

    }

}
