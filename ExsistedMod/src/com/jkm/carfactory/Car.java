package com.jkm.carfactory;

import com.jkm.frame.DemoInterfaceImpl;

public class Car {
    private boolean enginStat;
    private double carWeight;

    public Car(){
    }
    public Car(double carWeight ) {
        this.enginStat = false;
        this.carWeight = carWeight;
    }

    public double getCarWeight() {
        return carWeight;
    }

    public boolean isEnginStat() {
        return enginStat;
    }

    public void setEnginStat(boolean enginStat) {
        this.enginStat = enginStat;
    }

    public void setCarWeight(double carWeight) {
        this.carWeight = carWeight;
    }

    public void Activate(){
        enginStat = true;
        System.out.println(enginStat);
    }
    public void Deactivate(){
        enginStat = false;
        System.out.println(enginStat);
    }
}
