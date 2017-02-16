package com.sample.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
@Entity
public class Expenditure {

    private long id;
    private String type;
    private double amount;
    private Date date;

    private Expenditure(){}

    public Expenditure(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date=new Date();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @NotNull
    @Temporal(value = TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Expenditure{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

