package com.codeup.teddyblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        int sum = num1 + num2;
        return "The sum of " + num1 + " and " + num2 + " is " + sum + ".";
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        int difference = num2 - num1;
        return "The difference of " + num1 + " and " + num2 + " is " + difference + ".";
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        int product = num1 * num2;
        return "The product of " + num1 + " and " + num2 + " is " + product + ".";
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable float num1, @PathVariable float num2) {
        float quotient = num1 / num2;
        return "The quotient of " + num1 + " and " + num2 + " is " + quotient + ".";
    }
}
