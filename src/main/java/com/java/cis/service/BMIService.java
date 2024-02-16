package com.java.cis.service;

import org.springframework.stereotype.Service;

@Service
public class BMIService {
    public String calculateBMI(double heightInInches, double weightInPounds){
        double bmi = weightInPounds / (heightInInches * heightInInches) * 703;
        String formattedBMI = String.format("%.2f", bmi);
        return formattedBMI;
    }
}
