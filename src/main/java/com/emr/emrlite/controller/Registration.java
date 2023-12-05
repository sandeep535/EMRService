package com.emr.emrlite.controller;

import com.emr.emrlite.dto.RegistrationDTO;
import com.emr.emrlite.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class Registration {

    private final RegistrationService registrationService;
    @PostMapping
    public String saveRegistration(@RequestBody RegistrationDTO registrationDTO){
        registrationService.saveregistation(registrationDTO);
        return "Saved Sucessfully";
    }

    @GetMapping("/getDatabasedonmobilenumber/{mobileNumber}")
    public RegistrationDTO getClientDataBasedonmobilenumber(@PathVariable("mobileNumber") String mobileNumber) {
        RegistrationDTO d =registrationService.getClientDataBasedonmobilenumber(mobileNumber);
       return d;
    }

}
