package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        return mathService.volume(length, width, height);
    }

    @RequestMapping("/math/area")
    public String postArea(@RequestParam String type, @RequestParam Map<String, String> params) {
        switch (type){
            case "circle":
                if(params.get("radius") == null){
                    return "Invalid";
                }
                int radius = Integer.parseInt(params.get("radius"));
                double area = Math.PI * radius * radius;
                area = (double)Math.round(area * 100000d) / 100000d;
                return "Area of a circle with a radius of " + radius + " is " + area;

            case "rectangle":
                if(params.get("width") == null || params.get("width") == null){
                    return "Invalid";
                }
                int width = Integer.parseInt(params.get("width"));
                int height = Integer.parseInt(params.get("height"));
                return "Area of a " + width + "x" + height +" rectangle is " + width*height ;
        }
        return "Invalid";
    }
}
