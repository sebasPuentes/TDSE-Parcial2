package edu.parcial.pell.MathServicePell.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathService{

    public int pell(int n){
        int newValue = n;
        List sequence = new ArrayList<>();
        if(n<=1){
            return n;
        }else{
            return 2*pell(n-1) + pell(n-2);
        }
    }


}