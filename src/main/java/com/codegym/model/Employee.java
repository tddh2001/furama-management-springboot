package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotBlank(message = "Not Blank!")
    private String employeeName;
    @Past(message = "Invalid")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "Invalid")
    @NotBlank(message = "Not blank!")
    private String employeeIDCard;
    @NotNull(message = "Not blank!")
    @DecimalMin(value = "0.0", message = "Must be greater than 0")
    private double employeeSalary;
    @Pattern(regexp = "^((\\(84\\)\\+)|(0))((91)|(90)|(84)|(85)|(93)|(94)|(96)|(38))[\\d]{7}$", message = "Invalid phone number")
    @NotBlank(message = "Not blank!")
    private String employeePhone;
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email")
    @NotBlank(message = "Not blank!")
    private String employeeEmail;
    @NotBlank(message = "Not blank!")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender employeeGender;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(String employeeName, Date employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division, User user) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
    }

    public Employee(int employeeId, String employeeName, Date employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division, User user) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
    }

    public Gender getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Gender employee_gender) {
        this.employeeGender = employee_gender;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employee_id) {
        this.employeeId = employee_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employee_name) {
        this.employeeName = employee_name;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employee_birthday) {
        this.employeeBirthday = employee_birthday;
    }

    public String getEmployeeIDCard() {
        return employeeIDCard;
    }

    public void setEmployeeIDCard(String employee_id_card) {
        this.employeeIDCard = employee_id_card;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employee_salary) {
        this.employeeSalary = employee_salary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employee_phone) {
        this.employeePhone = employee_phone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employee_email) {
        this.employeeEmail = employee_email;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employee_address) {
        this.employeeAddress = employee_address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
