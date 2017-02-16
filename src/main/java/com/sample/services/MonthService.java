package com.sample.services;

import com.sample.model.Month;
import com.sample.repository.MonthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aanu.oyeyemi on 16/01/2017.
 * Project name -> OAuthS
 */
@Service
public class MonthService {

    private MonthRepo monthRepo;

    @Autowired
    public MonthService(MonthRepo monthRepo) {
        this.monthRepo = monthRepo;
    }

    public Month save(Month month){
        return monthRepo.save(month);
    }

    public Month getById(Long id){
        return monthRepo.findOne(id);
    }

    public Iterable<Month> getAll(){
        return monthRepo.findAll();
    }

    public void delete (long id){
        monthRepo.delete(id);
    }





}
