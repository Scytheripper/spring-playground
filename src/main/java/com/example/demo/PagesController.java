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
        String ret = "";
        int sum = 0;
        Iterator<Integer> nIterator = n.iterator();

        while(nIterator.hasNext()) {
            int current = nIterator.next();
            sum += current;
            ret += current + " + ";
        }

        //length - 3 to overwrite extra "+" which appends to the last element, REFACTORD
        return ret.substring(0,ret.length() - 3) + " = " + sum;
    }
}
