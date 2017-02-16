package com.sample.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
@Entity
public class Record {

    private int id;
    private double total_amount;
    private Set<Expenditure> expenditures;
    private Date date;


    private Record(){}

    public Record(Date date) {
        this.date=date;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(columnDefinition = "double")
    public double getTotal_amount() {
        this.expenditures.forEach(spending->this.total_amount+=spending.getAmount());

        return this.total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<Expenditure> getExpenditures() {
        return expenditures;
    }


    public void setExpenditures(Set<Expenditure> expenditures) {
        this.expenditures = expenditures;
    }


    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", total_amount=" + total_amount +
                ", expenditures=" + expenditures +
                '}';
    }
}
