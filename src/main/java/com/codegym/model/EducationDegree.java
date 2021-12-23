package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int education_degree_id;
    private String education_degree_name;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(int education_degree_id, String education_degree_name, List<Employee> employeeList) {
        this.education_degree_id = education_degree_id;
        this.education_degree_name = education_degree_name;
        this.employeeList = employeeList;
    }

    public EducationDegree(String education_degree_name, List<Employee> employeeList) {
        this.education_degree_name = education_degree_name;
        this.employeeList = employeeList;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public String getEducation_degree_name() {
        return education_degree_name;
    }

    public void setEducation_degree_name(String education_degree_name) {
        this.education_degree_name = education_degree_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
