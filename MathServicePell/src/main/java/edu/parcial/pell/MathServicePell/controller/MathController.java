package edu.parcial.pell.MathServicePell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.parcial.pell.MathServicePell.service.MathService;

@RestController
public class MathController{

    private final MathService mathService;

    public MathController(MathService mathService){
        this.mathService = mathService;
    }

    @GetMapping("/pellseq")
    public String getPell(int n){
        return String.valueOf(mathService.pell(n));
    }
}