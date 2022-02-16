package com.example.BddSpringboot.cucumber.hooks;

import com.example.BddSpringboot.cucumber.UserRepository;
import io.cucumber.java.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    UserRepository userRepository;

    @Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
        userRepository.deleteAll();
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }
}
