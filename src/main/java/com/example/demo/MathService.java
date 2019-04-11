package com.example.demo;

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
}
