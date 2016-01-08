package myth.com.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration 
@RequestMapping("/hello") 
public class HelloController {
  
	@RequestMapping
    public String hello(){   
        return "hello，Spring Boot ！";   
    }   
  
    public static void main(String[] args) {   
        //第一个简单的应用，   
        SpringApplication.run(HelloController.class,args);   
  
    }   
}
