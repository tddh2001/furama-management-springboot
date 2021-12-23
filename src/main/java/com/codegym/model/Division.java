package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int division_id;
    private String division_name;

    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(String division_name, List<Employee> employeeList) {
        this.division_name = division_name;
        this.employeeList = employeeList;
    }

    public Division(int division_id, String division_name, List<Employee> employeeList) {
        this.division_id = division_id;
        this.division_name = division_name;
        this.employeeList = employeeList;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
