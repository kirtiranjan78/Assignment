package com.mindfire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindfire.model.PerformanceResponse;
/**
 * Service interface for managing performance records for employees.
 * Provides methods for adding and retrieving performance records.
 * 
 * Implementing classes should provide the logic for interacting with
 * performance data, such as saving performance records and fetching them
 * based on employee ID.
 */
@Service
public interface PerformanceService {
	PerformanceResponse addPerformanceResponse(PerformanceResponse performanceResponse,int employeeId);
	List<PerformanceResponse> getPerformanceByEmployeeId(int employeeId);
}
