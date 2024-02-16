package com.java.cis.controllers;
import java.util.Locale;

import com.java.cis.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBMIController {
    private BMIService service;

    //public BMIService service;// variable level
    /*@Autowired
    public BMIService service; // variable level dependency injection (Loosely coupled)*/
    @Autowired // constructor level dependency injection (Tightly coupled)
    public void BMIController(BMIService service){
        this.service = service;
    }

    public RestBMIController(BMIService service) {
        this.service = service;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String input(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        return "BMICalculator";
    }*/
    @RequestMapping(value = "/bmirest", method = RequestMethod.POST)
    public String result(@RequestParam("height") double heightInInches,
                         @RequestParam("weight") double weightInPounds,
                         Model model) {
        //BMIService service = new BMIService();
        String formattedBMI = service.calculateBMI(heightInInches,weightInPounds);
        //model.addAttribute("bmi",formattedBMI);
        return formattedBMI;
    }
}