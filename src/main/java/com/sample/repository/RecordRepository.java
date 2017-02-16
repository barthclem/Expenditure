package com.sample.repository;

import com.sample.model.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
public interface RecordRepository extends CrudRepository<Record,Long> {

    Record findByDate(Date date);
}
