package yongsik.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import yongsik.springframework.services.GreetingService;

@Controller
public class GetterInjectedController {
    private GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

    @Autowired
    public void setGreetingService(@Qualifier("getterGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
}