package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, length = 10)
    private String code;

    @Column(precision = 19, scale = 2)
    private BigDecimal totalAnnualBudget;

    @Column(precision = 19, scale = 2)
    private BigDecimal remainingBudget;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "departments")
    @JsonIgnore
    private List<Project> projects;

    @OneToMany(mappedBy = "department")
    private List<SystemUser> employees;

    public Department() {
    }

    public Department(Long id, String name, String code, BigDecimal totalAnnualBudget, BigDecimal remainingBudget,
            LocalDateTime createdAt, List<Project> projects, List<SystemUser> employees) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.totalAnnualBudget = totalAnnualBudget;
        this.remainingBudget = remainingBudget;
        this.createdAt = createdAt;
        this.projects = projects;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getTotalAnnualBudget() {
        return totalAnnualBudget;
    }

    public void setTotalAnnualBudget(BigDecimal totalAnnualBudget) {
        this.totalAnnualBudget = totalAnnualBudget;
    }

    public BigDecimal getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(BigDecimal remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<SystemUser> getEmployees() {
        return employees;
    }

    public void setEmployees(List<SystemUser> employees) {
        this.employees = employees;
    }




    
    
}
