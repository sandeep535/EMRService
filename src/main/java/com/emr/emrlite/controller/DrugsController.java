package com.emr.emrlite.controller;

import com.emr.emrlite.dto.DrugMasterDTO;
import com.emr.emrlite.dto.LookUpDTO;
import com.emr.emrlite.dto.PrescriptionsDTO;
import com.emr.emrlite.service.CommonService;
import com.emr.emrlite.service.DrugsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RequestMapping("/api/drugs")
@RequiredArgsConstructor
public class DrugsController {
    private final DrugsService  drugsService;
    @GetMapping("/getDrugMasterData/{drugname}")
    public List<DrugMasterDTO> getDrugMasterData(@PathVariable("drugname") String drugname) {
        List<DrugMasterDTO> result =drugsService.getDrugMasterData(drugname);
        return result;
    }

    @PostMapping(value="/savePrescriptions")
    public List<PrescriptionsDTO> savePrescriptions(@RequestBody List<PrescriptionsDTO> prescriptionsDTO) {
        List<PrescriptionsDTO> result =drugsService.savePrescriptions(prescriptionsDTO);
        return result;
    }
}
