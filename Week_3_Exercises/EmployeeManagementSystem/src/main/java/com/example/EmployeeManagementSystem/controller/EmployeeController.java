package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees/dto")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.findEmployeeDTOs();
    }

    @GetMapping("/employees/projection")
    public List<EmployeeNameEmailProjection> getEmployeeProjections() {
        return employeeRepository.findEmployeeNameAndEmailWithDepartment();
    }

    // Get paginated list of employees
    @GetMapping("/paginated")
    public ResponseEntity<Page<Employee>> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeesPage = employeeRepository.findAll(pageable);

        return ResponseEntity.ok(employeesPage);
    }

    // Get sorted list of employees
    @GetMapping("/sorted")
    public ResponseEntity<List<Employee>> getEmployeesSorted(
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        List<Employee> employees = employeeRepository.findAll(sort);

        return ResponseEntity.ok(employees);
    }

    // Get paginated and sorted list of employees
    @GetMapping("/paginated-and-sorted")
    public ResponseEntity<Page<Employee>> getEmployeesPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy));
        Page<Employee> employeesPage = employeeRepository.findAll(pageable);

        return ResponseEntity.ok(employeesPage);
    }
}
