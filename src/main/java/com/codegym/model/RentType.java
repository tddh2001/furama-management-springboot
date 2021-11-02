package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rent_type_id;
    private String service_type_name;
    private double service_type_cost;

    @OneToMany(mappedBy = "rentType")
    private List<Service> serviceList;

    public RentType() {
    }

    public RentType(String service_type_name, double service_type_cost, List<Service> serviceList) {
        this.service_type_name = service_type_name;
        this.service_type_cost = service_type_cost;
        this.serviceList = serviceList;
    }

    public RentType(int rent_type_id, String service_type_name, double service_type_cost, List<Service> serviceList) {
        this.rent_type_id = rent_type_id;
        this.service_type_name = service_type_name;
        this.service_type_cost = service_type_cost;
        this.serviceList = serviceList;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }

    public double getService_type_cost() {
        return service_type_cost;
    }

    public void setService_type_cost(double service_type_cost) {
        this.service_type_cost = service_type_cost;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
