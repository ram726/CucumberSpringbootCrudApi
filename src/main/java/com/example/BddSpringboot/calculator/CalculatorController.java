package com.example.BddSpringboot.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add/{x}/{y}")
    public Calculator add(@PathVariable int x, @PathVariable  int y){
        return new Calculator(x, y, x+y);
    }

    @GetMapping("/sub/{x}/{y}")
    public Calculator sub(@PathVariable int x, @PathVariable  int y){
        return new Calculator(x, y, x-y);
    }

    @GetMapping("/div/{x}/{y}")
    public Calculator div(@PathVariable int x, @PathVariable  int y){
        return new Calculator(x, y, x/y);
    }

    @GetMapping("/mul/{x}/{y}")
    public Calculator mul(@PathVariable int x, @PathVariable  int y){
        return new Calculator(x, y, x*y);
    }

}
