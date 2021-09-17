package com.example.demo;

import com.example1.service.User;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan( {"com.example.demo" , "com.example1.service"} )
@SpringBootApplication
public class Demo1Application {
    
    @Bean
    public User userBean() {
        return new User("Arunachala","Sri Ramana") ;
    }
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = SpringApplication.run(Demo1Application.class, args);
        String[] beans = ctx.getBeanDefinitionNames() ;
        int count = 0;
        for(String s:beans)
            System.out.println(s +":"+ count++);
    }

}
