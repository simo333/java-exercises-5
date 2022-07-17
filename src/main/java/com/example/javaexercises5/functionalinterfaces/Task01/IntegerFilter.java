package com.example.javaexercises5.functionalinterfaces.Task01;

public class IntegerFilter implements Filter<Integer> {
    @Override
    public boolean check(Integer v) {
        return v < 20;
    }
}
