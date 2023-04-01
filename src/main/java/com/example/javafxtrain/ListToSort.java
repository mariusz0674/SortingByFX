package com.example.javafxtrain;

import java.util.ArrayList;

public class ListToSort extends ArrayList<Integer>{
    public void swap(Integer a, Integer b){
        Integer temp = super.get(a);
        super.set(a, super.get(b));
        super.set(b, temp);
    }
}
