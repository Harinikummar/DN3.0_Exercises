package com.example.EmployeeManagementSystem.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "Department.findByNameNamedQuery",
                query = "SELECT d FROM Department d WHERE d.name = :name"),
        @NamedQuery(name = "Department.findByPartialNameNamedQuery",
                query = "SELECT d FROM Department d WHERE d.name LIKE :partialName")
})
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Setter
    @Getter
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
