package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find department by name
    Department findByName(String name);

    // Custom JPQL query to find departments by name ignoring case
    @Query("SELECT d FROM Department d WHERE LOWER(d.name) = LOWER(:name)")
    Department findByNameIgnoreCase(@Param("name") String name);

    // Custom native SQL query to find departments with names starting with a letter
    @Query(value = "SELECT * FROM Department d WHERE d.name LIKE :letter%", nativeQuery = true)
    List<Department> findDepartmentsStartingWith(@Param("letter") String letter);
}
