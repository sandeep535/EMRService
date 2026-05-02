package com.emr.emrlite.controller;

import com.emr.emrlite.dto.LoginDTO;
import com.emr.emrlite.dto.LoginResponseDTO;
import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.repository.EmployeeRepository;
import com.emr.emrlite.service.TokenBlacklistService;
import com.emr.emrlite.utils.EMRSecurityContextHolder;
import com.emr.emrlite.utils.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000", }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST })
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

	@Autowired
	private TokenBlacklistService tokenBlacklistService;

	@PostMapping("/signin")
	public LoginResponseDTO authenticateUser(@RequestBody LoginDTO loginDto) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtil.generateToken(loginDto.getUsername());
			EmployeeModel context = EMRSecurityContextHolder.getContext().getEmploye();
			LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
			loginResponseDTO.setRole(context.getRole());
			loginResponseDTO.setId(context.getId());
			loginResponseDTO.setDesignation(context.getDesignation());
			loginResponseDTO.setGender(context.getGender());
			loginResponseDTO.setEmpid(context.getEmpid());
			loginResponseDTO.setFirstname(context.getFirstname());
			loginResponseDTO.setLastname(context.getLastname());
			loginResponseDTO.setTitle(context.getTitle());
			loginResponseDTO.setToken(jwt);
			return loginResponseDTO;
		} catch (Exception e) {
			e.printStackTrace();
			LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
			loginResponseDTO.setToken("false");
			return loginResponseDTO;
		}
	}

	@PostMapping("/signout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return ResponseEntity.badRequest().body("No token given or available to logout");
		}
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);
		tokenBlacklistService.blacklist(token, username);
		SecurityContextHolder.clearContext();
		return ResponseEntity.ok("Logged out successfully");
	}
}