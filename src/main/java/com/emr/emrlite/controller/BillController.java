package com.emr.emrlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.model.BillModel;
import com.emr.emrlite.service.BillService;

@CrossOrigin(origins = { "http://localhost:3000", }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST })

@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping
	public Long generateBill(@RequestBody BillGenerationDTO billGenerationDTO) {
		Long billid = billService.generateBill(billGenerationDTO);
		return billid;

	}

	@GetMapping
	public List<BillModel> getBills(@RequestParam Long visitId) {

		List<BillModel> bills = billService.getBills(visitId);
		return bills;

	}

}
