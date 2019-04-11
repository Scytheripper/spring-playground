package com.example.demo;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PagesController {

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
        switch (operation){
            case "add":
                return x + " + " + y + " = " + (x + y);

            case "multiply":
                return x + " * " + y + " = " + (x * y);

            case "subtract":
                return x + " - " + y + " = " + (x - y);

            case "divide":
                return x + " / " + y + " = " + (x / y);

        }

        return "";
    }
}
