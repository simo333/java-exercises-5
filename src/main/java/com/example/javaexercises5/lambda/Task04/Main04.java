package com.example.javaexercises5.lambda.Task04;

public class Main04 {
    public static void main(String[] args) {
        Calculate squareNumber = number -> Math.pow((Double) number, 2);
        Calculate sqrtNumber = number -> Math.sqrt((Double) number);
        Calculate factorialNumber = number -> {
            long fact = 1;
            for (int i = 2; i <= (Integer) number; i++) {
                fact = fact * i;
            }
            return fact;
        };

        /* V2 */
        Calculate squareNumberV2 = number -> {
            if (number instanceof Double numb) {
                return Math.pow(numb, 2);
            }
            throw new IllegalArgumentException("Must be Double");
        };

        Calculate sqrtNumberV2 = number -> {
            if (number instanceof Double numb) {
                return Math.sqrt(numb);
            }
            throw new IllegalArgumentException("Must be Double");
        };

        Calculate factorialNumberV2 = number -> {
            if (number instanceof Integer numb) {
                int fact = 1;
                for (int i = 2; i <= numb; i++) {
                    fact = fact * i;
                }
                return fact;
            }
            throw new IllegalArgumentException("Must be Integer");
        };
    }
}
