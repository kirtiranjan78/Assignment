package com.mindfire.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.entity.Performance;
/**
 * Repository interface for performing CRUD operations on {@link Performance} entities.
 * Extends {@link JpaRepository} to provide basic persistence operations such as saving, updating, deleting,
 * and querying performance records.
 * 
 * This repository also includes a custom query method to retrieve all performance records by a specific employee ID.
 */
@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Integer>{
	List<Performance> findAllByEmployeeId(int employeeId);
}
