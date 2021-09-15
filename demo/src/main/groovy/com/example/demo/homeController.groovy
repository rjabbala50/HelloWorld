package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class homeController {
    @RequestMapping("/")
    String home() {
        return "Hey Raj , whats app "
    }

}
