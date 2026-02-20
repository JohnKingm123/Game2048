package com.jkm.carfactory;

public class Driver {
    Car ownCar;
    int age;

    public Driver() {
    }

    public Driver(Car ownCar, int age) {
        this.ownCar = ownCar;
        this.age = age;
    }

    public Car getOwnCar() {
        return ownCar;
    }

    public int getAge() {
        return age;
    }

    public void setOwnCar(Car ownCar) {
        this.ownCar = ownCar;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
