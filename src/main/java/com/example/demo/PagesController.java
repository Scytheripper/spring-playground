package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
public class PagesController {

    private MathService mathService = new MathService();

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }

    @GetMapping("/math/calculate")
    public String getCalculation(@RequestParam(value="operation", defaultValue = "add")String operation,
                                 @RequestParam(required = true) int x, @RequestParam(required = true) int y) {

        return mathService.calculate(operation, x, y);
    }

    @PostMapping("/math/sum")
    public String postSum(@RequestParam List<Integer> n) {
        return mathService.sum(n);
    }
}
