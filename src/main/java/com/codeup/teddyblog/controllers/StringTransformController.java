package com.codeup.teddyblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.*;

@Controller
public class StringTransformController {
    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverseString(@PathVariable String string){
        StringBuilder string1 = new StringBuilder();

        string1.append(string);
        string1 = string1.reverse();
        return string1.toString();

    }

    @GetMapping("/string/caps/{string}")
    @ResponseBody
    public String capsString(@PathVariable String string){
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String ReverseAndAllCaps(@PathVariable String string) {
        return string.reverseString
    }

}
