package com.example.javaexercises5.dateapi.Task05;

import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Main05 {
    public static void main(String[] args) {
        OpenCloseValidator openCloseValidator = new OpenCloseValidator();
        openCloseValidator.configureWork(Paths.get("src/main/resources/config.txt"));
        openCloseValidator.checkOIfOpen(LocalDateTime.of(2022, 4, 16, 18, 0));

    }
}
