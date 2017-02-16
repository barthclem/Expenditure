package com.sample.services;

import com.sample.model.Expenditure;
import com.sample.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
@Service
public class ExpenditureService {

    private ExpenditureRepository expenditureRepository;

    @Autowired
    public ExpenditureService(ExpenditureRepository expenditureRepository) {
        this.expenditureRepository = expenditureRepository;
    }

    public Expenditure save(Expenditure expenditure){
        return expenditureRepository.save(expenditure);
    }

    public Iterable<Expenditure> getAll(){
        return  expenditureRepository.findAll();
    }

    public Expenditure findById(long id){
        return expenditureRepository.findOne(id);
    }

    public Expenditure findByName(String name){
        return expenditureRepository.findByType(name);
    }

    public Iterable<Expenditure> findAllByName(String name){
        return expenditureRepository.findAllByType(name);
    }
    public Iterable<Expenditure> findAllByDate(Date date){
        return expenditureRepository.findAllByDate(date);
    }
    public Iterable<Expenditure> findAllByNameAndDate(String name,Date date){
        return expenditureRepository.findAllByTypeAndDate(name,date);
    }


    public void delete(long id){
        expenditureRepository.delete(id);
    }


}
