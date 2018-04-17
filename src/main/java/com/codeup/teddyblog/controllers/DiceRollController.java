package com.codeup.teddyblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DiceRollController {
    @GetMapping("/roll-dice")
    public String diceRoll() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String game(@PathVariable int guess, Model model){

        int roll = (int)Math.floor(Math.random() * 6) + 1;
        //Added boolean to compare roll and guess in controller instead of view
        boolean result = (roll == guess);
        model.addAttribute("roll", roll);
        model.addAttribute("guess", guess);
        model.addAttribute("result", result);
        return "die-roll";
    }

}
