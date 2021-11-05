package com.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameMethod;
    private Date date;
    private String nameUpdate;
    private String iDUpDate;
    private String byAccount;

    public Log() {
    }

    public Log(String nameMethod, Date date) {
        this.nameMethod = nameMethod;
        this.date = date;
    }

    public Log(String nameMethod, Date date, String nameUpdate, String iDUpDate, String byAccount) {
        this.nameMethod = nameMethod;
        this.date = date;
        this.nameUpdate = nameUpdate;
        this.iDUpDate = iDUpDate;
        this.byAccount = byAccount;
    }

    public Log(String nameMethod, Date date, String nameUpdate, String iDUpDate) {
        this.nameMethod = nameMethod;
        this.date = date;
        this.nameUpdate = nameUpdate;
        this.iDUpDate = iDUpDate;
    }

    public Log(Date date, String nameUpdate) {
        this.date = date;
        this.nameUpdate = nameUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameUpdate() {
        return nameUpdate;
    }

    public void setNameUpdate(String nameUpdate) {
        this.nameUpdate = nameUpdate;
    }

    public String getiDUpDate() {
        return iDUpDate;
    }

    public void setiDUpDate(String iDUpDate) {
        this.iDUpDate = iDUpDate;
    }

    public String getByAccount() {
        return byAccount;
    }

    public void setByAccount(String byAccount) {
        this.byAccount = byAccount;
    }
}
