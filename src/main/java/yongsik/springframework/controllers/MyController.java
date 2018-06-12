package yongsik.springframework.controllers;

import org.springframework.stereotype.Controller;

import yongsik.springframework.services.GreetingService;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("Hello!!! ");

        return greetingService.sayGreeting();
    }
    
}
