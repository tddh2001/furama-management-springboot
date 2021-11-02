package com.codegym.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`user`")
public class    User {
    @Id
    private String username;
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employeeList;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roleList;

    public User() {
    }

    public User(String username, String password, Employee employeeList, Set<Role> roleList) {
        this.username = username;
        this.password = password;
        this.employeeList = employeeList;
        this.roleList = roleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Employee employeeList) {
        this.employeeList = employeeList;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

}
