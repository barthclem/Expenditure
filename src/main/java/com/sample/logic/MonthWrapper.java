package com.sample.logic;

import com.sample.model.Month;
import com.sample.model.Week;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by aanu.oyeyemi on 15/01/2017.
 * Project name -> OAuthS
 */
public class MonthWrapper {
    private static double amount;
    private static HashMap<String,String> report;
    private static HashMap<String,Double> expenses;
    private static HashMap<Long,HashMap<String,String>> data;
    private static Set<List<HashMap<String,String>>> datas;
    public static HashMap<String,String> getShortReport(Month month){
        report=new HashMap<>();
        report.put("Total Expenses",month.getTotal()+"");
        return report;
    }

    public static HashMap<Long,HashMap<String,String>> getByWeekShortReport(Month month){

        month.getWeeks().forEach(week -> {
            data.put((week.getId()%7)+1,WeekWrapper.getShortReport(week));
        });

        return data;
    }

    public static Set<List<HashMap<String,String>>> getByWeekFullReport(Month month){

        month.getWeeks().forEach(week -> {
            datas.add(WeekWrapper.getByDayFullReport(week));
        });

        return datas;
    }

    public static HashMap<String,Double>  getByExpenses(Month month){
        expenses = new HashMap<>();

        month.getWeeks().forEach(week -> {
            expenses=WeekWrapper.getByExpenses(week,expenses);
            });


        return  expenses;
    }
}
