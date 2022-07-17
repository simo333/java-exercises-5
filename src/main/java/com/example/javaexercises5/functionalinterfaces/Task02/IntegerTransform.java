package com.example.javaexercises5.functionalinterfaces.Task02;

public class IntegerTransform implements Transform<Integer, Integer> {
    @Override
    public Integer transform(Integer integer) {
        return integer - 1;
    }
}
