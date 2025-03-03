package com.mindfire.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfire.entity.Performance;
import com.mindfire.model.PerformanceResponse;
import com.mindfire.repo.PerformanceRepository;
import com.mindfire.service.PerformanceService;
/**
 * Service implementation class for handling performance-related operations.
 * Implements the {@link PerformanceService} interface to provide functionality
 * for adding and retrieving performance records.
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private PerformanceRepository performanceRepository;

    /**
     * Adds a performance record for an employee.
     * 
     * This method maps the incoming {@link PerformanceResponse} to a {@link Performance} entity,
     * sets the employee ID, saves the performance record in the repository, 
     * and returns the saved record as a {@link PerformanceResponse}.
     * 
     * @param performanceResponse The {@link PerformanceResponse} object that contains the performance data to be saved.
     * @param employeeId The ID of the employee for whom the performance record is being added.
     * @return A {@link PerformanceResponse} object representing the saved performance record.
     */
    @Override
    public PerformanceResponse addPerformanceResponse(PerformanceResponse performanceResponse, int employeeId) {
        Performance performance = modelMapper.map(performanceResponse, Performance.class);
        performance.setEmployeeId(employeeId); 
        return modelMapper.map(performanceRepository.save(performance), PerformanceResponse.class);
    }

    /**
     * Retrieves all performance records for a specific employee.
     * 
     * This method fetches all performance records associated with the given employee ID from the repository,
     * maps each {@link Performance} entity to a {@link PerformanceResponse}, and returns a list of these responses.
     * 
     * @param employeeId The ID of the employee whose performance records are to be fetched.
     * @return A list of {@link PerformanceResponse} objects representing the performance records of the employee.
     */
    @Override
    public List<PerformanceResponse> getPerformanceByEmployeeId(int employeeId) {
        List<PerformanceResponse> list = new ArrayList<>();
        List<Performance> allByEmployeeId = performanceRepository.findAllByEmployeeId(employeeId);
        for (Performance performance : allByEmployeeId) {
            list.add(modelMapper.map(performance, PerformanceResponse.class));
        }
        return list;
    }

}