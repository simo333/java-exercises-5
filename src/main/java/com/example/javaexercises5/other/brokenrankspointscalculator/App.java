package com.example.javaexercises5.other.brokenrankspointscalculator;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PointsCounter.showPoints(66);
        System.out.println(PointsCounter.countTotalPointsCost(List.of(
                "3a", // rozprucie
                "6s", // rzut
                "4a", // furia
                "3a", // dyńka
                "3s", // skóra
                "3m", // krytyczny
                "7s", // taran
                "3a" // fala
                // amok
                // wataha
        )));
    }
}

/* Stan na 10.12.2022: lvl 66 */
// rozprucie 5a
// rzut 5a
// furia 3a
// dynka 5a
// skóra 0
// krytyczny 2m
// taran 7s
// fala 6a
// amok 0
// wataha 0