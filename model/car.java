package main;

public abstract class Car {

    protected String model;

    public Car(String model) {
        this.model = model;
    }

    public void start() {
        System.out.println(model + " started");
    }

    public abstract void showFeatures();
}
