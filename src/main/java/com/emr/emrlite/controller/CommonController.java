package com.emr.emrlite.controller;


import com.emr.emrlite.dto.LookUpDTO;
import com.emr.emrlite.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/common")
@RequiredArgsConstructor
public class CommonController {

    private final CommonService commonService;
    @GetMapping("/lookupdata/{lookuptype}")
    public HashMap<String, List<LookUpDTO>> getClientDataBasedonmobilenumber(@PathVariable("lookuptype") List<String> lookuptype) {
        HashMap<String, List<LookUpDTO>> d =commonService.getLookupData(lookuptype);
        return d;
    }
}
