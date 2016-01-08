package com.myth.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	
	@ExceptionHandler({RuntimeException.class})  
    public String exception(RuntimeException e) {  
        System.out.println("exception ...");  
        //e.printStackTrace();  
        return "exception";  
    } 
}
