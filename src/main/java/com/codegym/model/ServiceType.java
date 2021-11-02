package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_type_id;
    private String service_type_name;

    @OneToMany(mappedBy = "serviceType")
    private List<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(String service_type_name, List<Service> serviceList) {
        this.service_type_name = service_type_name;
        this.serviceList = serviceList;
    }

    public ServiceType(int service_type_id, String service_type_name, List<Service> serviceList) {
        this.service_type_id = service_type_id;
        this.service_type_name = service_type_name;
        this.serviceList = serviceList;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
