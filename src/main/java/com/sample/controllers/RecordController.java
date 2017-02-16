package com.sample.controllers;

import com.sample.model.Record;
import com.sample.services.RecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aanu.oyeyemi on 16/01/2017.
 * Project name -> OAuthS
 */
@Configuration
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordServices service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Record> save(@RequestBody Record record){
        Record record1=service.saveRecord(record);
        return new ResponseEntity<Record>(record1, HttpStatus.ACCEPTED);
    }
}
