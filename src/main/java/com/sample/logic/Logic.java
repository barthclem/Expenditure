package com.sample.logic;

import com.sample.exceptions.WeekException;
import com.sample.model.Expenditure;
import com.sample.model.Record;

import java.util.*;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
public class Logic {
    private double amount;

    public double getForFirstWeek(Iterable<Record> records){
        //get for seven days
        amount=0;
        List<Record> recordList=new ArrayList<>();
        Iterator<Record> recordIterator=records.iterator();
        recordIterator.forEachRemaining(record -> {recordList.add(record);});

        if(recordList.size()<7) throw new WeekException("The number of records is not upto a week");


        recordList.forEach(record -> amount+=getRecordSpending(record));

        return 0;
    }
    public double getForLastMonth(){
        return 0;
    }
    public double getRecordSpending(Record record){
        amount=0;
        Set<Expenditure> expenditures=record.getExpenditures();
        expenditures.forEach(expenditure -> {amount+=expenditure.getAmount();});
        return amount;
    }
}
