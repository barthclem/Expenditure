package com.sample.logic;

import com.sample.model.Record;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by aanu.oyeyemi on 15/01/2017.
 * Project name -> OAuthS
 */
public class RecordWrapper  {

     private static HashMap<String,String>  report;



    public static HashMap<String,String> getFullRecordAnalysis(Record record){
        report=new HashMap<>();
        report.put(" Record "+record.getId() ," Full Analysis \n\n\tExpenditure\t\t\tAmount\n\n");

        record.getExpenditures().forEach(
                expenditure -> {
                    report.put(expenditure.getType(),expenditure.getAmount()+"");
                }
        );

        report.put("Total Expenses",record.getTotal_amount()+"");
        return report;
    }

    public static HashMap<String,String> printShortRecordAnalysis(Record record){
        report=new HashMap<>();
        report.put("Total Expenses",record.getTotal_amount()+"");
        return report;
    }
}
