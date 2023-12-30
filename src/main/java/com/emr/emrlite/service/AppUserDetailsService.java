package com.emr.emrlite.service;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.repository.DrugMasterRepository;
import com.emr.emrlite.repository.EmployeeRepository;
import com.emr.emrlite.utils.ExecutionContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername -1"+username);
        EmployeeModel employeeModel = employeeRepository.findEmployeeModelByUsername(username);
        ExecutionContext context = new ExecutionContext();
        context.setEmploye(employeeModel);
        System.out.println("loadUserByUsername-2"+employeeModel.getPassword());
        Set<GrantedAuthority> gauth = new HashSet<>();
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("Admin");
        Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) arrayList
                .stream()
                .map((role) -> new SimpleGrantedAuthority((String) role)).collect(Collectors.toSet());
        User user = new User(employeeModel.getUsername(),employeeModel.getPassword(),authorities);
        System.out.println("loadUserByUsername-3"+user);
       // System.out.println("loadUserByUsername-3"+ context.getEmployee().getTitle());

        return user;
    }
}
