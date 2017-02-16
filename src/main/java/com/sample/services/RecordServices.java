package com.sample.services;

import com.sample.model.Record;
import com.sample.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
@Service
public class RecordServices {

    private RecordRepository recordRepository;

    @Autowired
    public RecordServices(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Record saveRecord(Record record){
        return recordRepository.save(record);
    }

    public Iterable<Record> getAllRecords(){
        return recordRepository.findAll();
    }

    public Record findbyDate(Date date){
        return recordRepository.findByDate(date);
    }

    public Record findById(long id){
        return  recordRepository.findOne(id);
    }


    public void deleteById(long id){
        recordRepository.delete(id);
    }
}
