package com.sample.services;

import com.sample.model.Week;
import com.sample.repository.WeekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aanu.oyeyemi on 16/01/2017.
 * Project name -> OAuthS
 */
@Service
public class WeekService {
    private WeekRepo weekRepo;

    @Autowired
    public WeekService(WeekRepo weekRepo) {
        this.weekRepo = weekRepo;
    }

    public Week save(Week week){
        return weekRepo.save(week);
    }

    public Week getById(long id){
        return weekRepo.findOne(id);
    }

    public Iterable<Week> getAll(){
        return weekRepo.findAll();
    }

    public void delete(long id){
        weekRepo.delete(id);
    }
}
