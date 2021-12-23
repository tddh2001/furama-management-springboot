package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Pattern(regexp = "^(KH-)[\\d]{4}$", message = "The customer ID has the format KH-XXXX (X : 0-9)")
    @NotBlank(message = "ID cannot be empty!!")
    @Column(length = 50)
    private String customerId;

    @NotBlank(message = "Name cannot be empty!!")
    private String customerName;

    @Past(message = "Invalid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthday;

    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "IDcard invalid")
    @NotBlank(message = "ID card cannot be empty!!")
    private String customerIDCard;

    @Pattern(regexp = "^((\\(84\\)\\+)|(0))((91)|(90)|(84)|(85)|(93)|(94)|(96)|(38)|(88)|(39))[\\d]{7}$", message = "Invalid phone number")
    @NotBlank(message = "Phone number cannot be empty!")
    private String customerPhone;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email")
    @NotBlank(message = "Email cannot be empty!!")
    private String customerEmail;

    @NotBlank(message = "Address cannot be empty!!")
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender customerGender;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
    }

    public Customer(CustomerType customerType, String customerName, Date customerBirthday, String customerIDCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerIDCard = customerIDCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customer_id) {
        this.customerId = customer_id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customer_birthday) {
        this.customerBirthday = customer_birthday;
    }

    public Gender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Gender customer_gender) {
        this.customerGender = customer_gender;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getCustomerIDCard() {
        return customerIDCard;
    }

    public void setCustomerIDCard(String customer_iDCard) {
        this.customerIDCard = customer_iDCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customer_phone) {
        this.customerPhone = customer_phone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customer_email) {
        this.customerEmail = customer_email;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customer_address) {
        this.customerAddress = customer_address;
    }
}
