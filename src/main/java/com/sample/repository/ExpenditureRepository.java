package com.sample.repository;

import com.sample.model.Expenditure;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
public interface ExpenditureRepository  extends CrudRepository<Expenditure,Long>{


    Expenditure findByType(String name);

    Iterable<Expenditure> findAllByType(String name);

    Iterable<Expenditure> findAllByTypeAndDate(String name, Date date);

    Iterable<Expenditure> findAllByDate(Date date);
}
