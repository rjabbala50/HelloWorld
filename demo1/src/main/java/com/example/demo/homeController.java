package com.example.demo;

import com.example1.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    private NotificationService ns ;
    
    
    @Autowired
    public homeController(NotificationService ns) {
        this.ns = ns;
    }
 
    /*
    @RequestMapping("/")
    public String home() {
        return ns.noteIt();
    }
    */
    /*
    @RequestMapping("/error")
    public String error() {
        return "error"  ;
    }
    
    */
}