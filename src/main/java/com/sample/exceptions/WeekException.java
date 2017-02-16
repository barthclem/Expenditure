package com.sample.exceptions;

/**
 * Created by aanu.oyeyemi on 10/01/2017.
 * Project name -> OAuthS
 */
public class WeekException extends RuntimeException {
    public WeekException(){
        super();
    }

    public WeekException(String message){
        super(message);
    }
}
