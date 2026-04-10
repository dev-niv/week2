package main;

public class MidModel extends Car implements SafetySystem, Infotainment {

    public MidModel(String model) {
        super(model);
    }

    public void applyEmergencyBrake() {
        System.out.println("Emergency brake applied");
    }

    public void playMedia() {
        System.out.println("Playing music");
    }

    public void showFeatures() {
        System.out.println("Mid model with infotainment");
    }
}
