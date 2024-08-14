package com.example.EmployeeManagementSystem.dto;

public class EmployeeDTO {

    private String name;
    private String email;
    private String departmentName;

    public EmployeeDTO(String name, String email, String departmentName) {
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters and setters
}
