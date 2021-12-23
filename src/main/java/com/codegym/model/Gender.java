package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genderId;
    private String gender;

    @OneToMany(mappedBy = "customerGender")
    private List<Customer> customerList;

    @OneToMany(mappedBy = "employeeGender")
    private List<Employee> employeeList;

    public Gender() {
    }

    public Gender(String gender, List<Customer> customerList, List<Employee> employeeList) {
        this.gender = gender;
        this.customerList = customerList;
        this.employeeList = employeeList;
    }

    public Gender(int genderId, String gender, List<Customer> customerList) {
        this.genderId = genderId;
        this.gender = gender;
        this.customerList = customerList;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int gender_id) {
        this.genderId = gender_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
