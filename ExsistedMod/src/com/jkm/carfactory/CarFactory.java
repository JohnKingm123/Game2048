package com.jkm.carfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarFactory {
    public Car getCar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight:");
        double carWeight = sc.nextDouble();
        System.out.println("Set the engin status:");
        boolean enginStat = sc.nextBoolean();

        Car car = new Car();
        return car;
    }

    public static void main(String[] args) {
        Car auto = new Car(12);
        ReloadUsage ReloadMachine = new ReloadUsage();
        List<ReloadUsage> reloadUsageList = new ArrayList<ReloadUsage>();
        System.out.println(auto);

        double retDue = 0.0;

        retDue = ReloadMachine.DoubleAdd(1.2,3.3,23.1);
        System.out.println(retDue);
        retDue = ReloadMachine.DoubleAdd(1.2,3.3);
        System.out.println(retDue);
        auto.Activate();
        auto.Deactivate();
    }
}
