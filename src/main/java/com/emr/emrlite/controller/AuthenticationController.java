package com.emr.emrlite.controller;

import com.emr.emrlite.dto.LoginDTO;
import com.emr.emrlite.repository.EmployeeRepository;
import com.emr.emrlite.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/signin")
    public Object authenticateUser(@RequestBody LoginDTO loginDto){
        System.out.println("login controller --");
        try{
            System.out.println("login password --"+loginDto.getPassword());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateToken(loginDto.getUsername());
            System.out.println("login controller Success----");
            return jwt;
        }catch (Exception e){
            System.out.println("login controller-excepton----1"+e);
            return new ResponseEntity<>("Login Failed.", HttpStatus.valueOf(400));
        }
    }

}
