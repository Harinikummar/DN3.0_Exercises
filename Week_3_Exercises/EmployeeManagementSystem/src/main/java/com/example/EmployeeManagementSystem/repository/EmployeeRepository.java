package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find all employees with pagination and sorting
    Page<Employee> findAll(Pageable pageable);

    // Find all employees with sorting only
    List<Employee> findAll(Sort sort);

    // Find employees by department ID with pagination and sorting
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    @Query("SELECT e.name AS name, e.email AS email, d.name AS departmentName FROM Employee e JOIN e.department d")
    List<EmployeeNameEmailProjection> findEmployeeNameAndEmailWithDepartment();


    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDTO(e.name, e.email, d.name) FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findEmployeeDTOs();
}
