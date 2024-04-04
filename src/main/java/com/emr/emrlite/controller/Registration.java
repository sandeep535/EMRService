package com.emr.emrlite.controller;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.service.RegistrationService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class Registration {
	@Autowired
    RegistrationService registrationService;
	
    @PostMapping
    public RegistrationDTO saveRegistration(@RequestBody RegistrationDTO registrationDTO){
        RegistrationDTO result = registrationService.saveregistation(registrationDTO);
        return result;
    }

    @GetMapping("/getDatabasedonmobilenumber/{mobileNumber}")
    public List<RegistrationDTO> getClientDataBasedonmobilenumber(@PathVariable("mobileNumber") String mobileNumber) {
        List<RegistrationDTO> d =registrationService.getClientDataBasedonmobilenumber(mobileNumber);
       return d;
    }
    @GetMapping("/test")
    public String test() {
        System.out.println("Test");
        return "Test working";
    }

}
