package com.sample.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by aanu.oyeyemi on 15/01/2017.
 * Project name -> OAuthS
 */
@Entity
public class Week
{
    private long id;
    private Set<Record> dailyRecords;
    private double total;

    private Week(){}

    public Week(int i){


    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    public Set<Record> getDailyRecords() {

        return dailyRecords;
    }


    public void setDailyRecords(Set<Record> day) {
        this.dailyRecords = day;
    }

    public double getTotal() {
        total=0;
        getDailyRecords().forEach(record->{
            total+=record.getTotal_amount();
        });
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Week{" +
                "id=" + id +
                ", day=" + dailyRecords +
                ", total=" + total +
                '}';
    }
}
