package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int position_id;
    private String position_name;

    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;

    public Position() {
    }

    public Position(String position_name, List<Employee> employeeList) {
        this.position_name = position_name;
        this.employeeList = employeeList;
    }

    public Position(int position_id, String position_name, List<Employee> employeeList) {
        this.position_id = position_id;
        this.position_name = position_name;
        this.employeeList = employeeList;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
