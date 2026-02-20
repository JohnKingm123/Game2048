package com.jkm.carfactory;

public abstract class LivingThing {
     public abstract  void work();
}

class Cat extends LivingThing{
    @Override
    public void work() {
        System.out.println("asdasdada");
    }
}