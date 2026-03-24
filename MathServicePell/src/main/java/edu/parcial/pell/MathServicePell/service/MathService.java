package edu.parcial.pell.MathServicePell.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathService{

    public int pell(int n){
        if(n<=1){
            return n;
        }else{
            return 2*pell(n-1) + pell(n-2);
        }
    }

    public List<Integer> toListPell(int n){
        List<Integer> sequence = new ArrayList<>();
        for(int i=0;i < n+1; i++){
            sequence.add(pell(i));
        }
        return sequence;
    }


}