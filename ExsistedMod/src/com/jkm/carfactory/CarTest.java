package com.jkm.carfactory;

public class CarTest {
    public static void main(String[] args) {
        CarFactory factory0 = new CarFactory();
        Car auto = new Car(12);
        Car BMW = new Car(200);
        Car SBL = new Car(8);
        Car brokenCars[] = new Car[2];
        Car cars[] = new Car[]{auto, BMW, SBL};

        for(int i = 0;i<3;i++){
            System.out.println(cars[i]);
        }

        Car car = factory0.getCar();
        Driver John = new Driver(car, 18);
        System.out.println(John.getOwnCar());
        System.out.println(John.getAge());
    }
}
