package com.myth;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myth.controller.HelloController;

/**
* @author 
* @version 创建时间：2016年2月2日 上午9:14:08
* 
*/

@Configuration
@ComponentScan(value = {"com.myth"})
public class App{

//    public static ConfigurableApplicationContext run(Object source, String[] args) {
//        return SpringApplication.run(source, args);
//    }
    
	public static void main(String[] args) {
		// 第一个简单的应用，
		SpringApplication.run(App.class, args);

	}
}