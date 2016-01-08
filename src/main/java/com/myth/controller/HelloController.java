package com.myth.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/hello")
public class HelloController extends BaseController {

	@RequestMapping
	public String hello(@RequestParam(value = "tag", required = false) String tagParam) {
		System.out.println("tagParam = "+tagParam);
		if (tagParam != null && tagParam.equals("1")) {
			throw new RuntimeException("myException");
		}
		return "hello, Spring Boot ！";
	}

	public static void main(String[] args) {
		// 第一个简单的应用，
		SpringApplication.run(HelloController.class, args);

	}
	
	@ExceptionHandler({RuntimeException.class})  
    public String exception(RuntimeException e) {  
        System.out.println("child exception ...");  
        //e.printStackTrace();  
        return "exception";  
    } 
 
}
