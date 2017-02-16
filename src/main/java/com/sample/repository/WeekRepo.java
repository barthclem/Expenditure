package com.sample.repository;

import com.sample.model.Week;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aanu.oyeyemi on 16/01/2017.
 * Project name -> OAuthS
 */
public interface WeekRepo extends CrudRepository<Week,Long> {
}
