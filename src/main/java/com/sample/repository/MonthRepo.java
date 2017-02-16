package com.sample.repository;

import com.sample.model.Month;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aanu.oyeyemi on 16/01/2017.
 * Project name -> OAuthS
 */
public interface MonthRepo extends CrudRepository<Month,Long> {
}
