package com.mindfire.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO (Data Transfer Object) class representing a performance record response.
 * This class is used to transfer performance data between layers in the application
 * and is typically used in API responses to provide performance information.
 * 
 * It contains the performance rating, feedback, and the associated employee ID.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerformanceResponse {
	private int id;
	private int rating;
	private String feedback;
	private int employeeId;
	
}
