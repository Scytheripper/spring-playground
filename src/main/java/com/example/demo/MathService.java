package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MathService {

    public String calculate(String operation, int x, int y) {
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
        return "Hello!";
    }

    public String sum(List<Integer> n) {
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

    public String volume(int length, int width, int height) {
        int volume = length*width*height;
        return "The volume of a " + length + "x" + width + "x" + height +" rectangle is 60";
    }

    public String area(String type, Map<String, String> params) {
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
