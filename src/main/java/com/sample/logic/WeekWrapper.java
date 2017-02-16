package com.sample.logic;

import com.sample.model.Week;

import java.util.HashMap;
import java.util.List;

/**
 * Created by aanu.oyeyemi on 15/01/2017.
 * Project name -> OAuthS
 */
public class WeekWrapper {

    private static double amount;
    private static HashMap<String,String> report;
    private static HashMap<String,Double> expenses;
    private static List<HashMap<String,String>> data;

    public static HashMap<String,String> getShortReport(Week week){
        report=new HashMap<>();
        report.put("Total Expenses",week.getTotal()+"");
        return report;
    }

    public static List<HashMap<String,String>> getByDayShortReport(Week week){

        week.getDailyRecords().forEach(record -> {
            data.add(RecordWrapper.printShortRecordAnalysis(record));
        });

        return data;
    }

    public static List<HashMap<String,String>> getByDayFullReport(Week week){

        week.getDailyRecords().forEach(record -> {
            data.add(RecordWrapper.getFullRecordAnalysis(record));
        });

        return data;
    }

    public static HashMap<String,Double>  getByExpenses(Week week,HashMap<String,Double> expenses){


        week.getDailyRecords().forEach(record -> {
            record.getExpenditures().forEach(expenditure -> {
                if(!expenses.containsKey(expenditure.getType())){
                    expenses.put(expenditure.getType(),expenditure.getAmount());
                }
                else{
                    double amount=expenses.get(expenditure.getType());
                    amount += expenditure.getAmount();
                    expenses.replace(expenditure.getType(),expenditure.getAmount(),amount);

                }
            });
        });

        return  expenses;
    }
    public static HashMap<String,Double>  getByExpenses(Week week){
        return getByExpenses(week,new HashMap<>());
    }
}
