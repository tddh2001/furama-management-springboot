package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_type_id;
    private String customer_type_name;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(int customer_type_id, String customer_type_name, List<Customer> customerList) {
        this.customer_type_id = customer_type_id;
        this.customer_type_name = customer_type_name;
        this.customerList = customerList;
    }

    public CustomerType(String customer_type_name, List<Customer> customerList) {
        this.customer_type_name = customer_type_name;
        this.customerList = customerList;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
