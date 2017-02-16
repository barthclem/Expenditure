package com.sample.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by aanu.oyeyemi on 15/01/2017.
 * Project name -> OAuthS
 */
@Entity
public class Month {

    private long id;
    private Set<Week> weeks;
    private double total;

    private Month(){

    }

    public Month(int d){

    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Month{" +
                "id=" + id +
                ", weeks=" + weeks +
                ", total=" + total +
                '}';
    }
}
