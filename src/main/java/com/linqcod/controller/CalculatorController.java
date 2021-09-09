package com.linqcod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/calculate")
    public String Calculate(@RequestParam("value1") float value1,
                            @RequestParam("value2") float value2,
                            @RequestParam("operation") String operation,
                            Model model) {
        String result;

        switch (operation.toLowerCase(Locale.ROOT)) {
            case "addition":
                result = String.valueOf(value1 + value2);
                break;
            case "subtraction":
                result = String.valueOf(value1 - value2);
                break;
            case "multiplication":
                result = String.valueOf(value1 * value2);
                break;
            case "division":
                if (value2 != 0) {
                    result = "Divided by zero!";
                }
                else {
                    result = String.valueOf(value1 / value2);
                }
            default:
                result = "Wrong entries!";
                break;
        }

        model.addAttribute("result", result);
        return "calculator";
    }


}
