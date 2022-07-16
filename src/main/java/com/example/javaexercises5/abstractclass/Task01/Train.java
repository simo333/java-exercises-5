package com.example.javaexercises5.abstractclass.Task01;

public class Train extends Vehicle {
    private int trackWidth;     /* 600 – kolej wąskotorowa, 1435 – standardowa szerokość */

    public Train(Integer maxSpeed, String model, int trackWidth) {
        super(maxSpeed, model);
        this.trackWidth = trackWidth;
    }

    @Override
    public String getSound() {
        return "stuk stuk";
    }

    public int getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(int trackWidth) {
        this.trackWidth = trackWidth;
    }
}
