package myth.com.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration 

public class HelloController {
  
    @ResponseBody 
    @RequestMapping("/hello") 
    public String hello(){   
        return "hello，Spring Boot ！";   
    }   
  
    public static void main(String[] args) {   
        //第一个简单的应用，   
        SpringApplication.run(HelloController.class,args);   
  
    }   
}
