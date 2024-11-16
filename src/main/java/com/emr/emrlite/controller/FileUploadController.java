package com.emr.emrlite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emr.emrlite.dto.FileuploadDTO;
import com.emr.emrlite.service.FileUploadService;

@CrossOrigin(origins = { "http://localhost:3000", }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST })

@RestController
@RequestMapping("/api/common")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping(value = "/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestBody FileuploadDTO fileuploadDTO) {
		String s = fileUploadService.uploadFile(fileuploadDTO);
		return ResponseEntity.ok(s);

	}

}
