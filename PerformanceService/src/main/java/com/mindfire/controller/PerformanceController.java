package com.mindfire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindfire.model.PerformanceResponse;
import com.mindfire.service.PerformanceService;

import jakarta.validation.Valid;
/**
 * Controller class for managing performance-related requests for employees.
 * Exposes REST API endpoints for retrieving and adding performance records.
 */

@RestController
@RequestMapping("/performance")
public class PerformanceController {
	@Autowired
	private PerformanceService performanceService;
	@GetMapping("/getByEmployeeId/{id}")
	public ResponseEntity<List<PerformanceResponse>> getPerformance(@PathVariable int id){
		List<PerformanceResponse> list = performanceService.getPerformanceByEmployeeId(id);
		return new ResponseEntity<List<PerformanceResponse>>(list,HttpStatus.OK);
	}
	@PostMapping("/addPerformance/{employeeId}")
	public ResponseEntity<PerformanceResponse> addPerformance(@Valid @RequestBody PerformanceResponse performanceResponse,@PathVariable int employeeId){
		PerformanceResponse response = performanceService.addPerformanceResponse(performanceResponse,employeeId);
		return new ResponseEntity<PerformanceResponse>(response,HttpStatus.CREATED);
	}
}
