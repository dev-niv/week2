package main;

public class TopModel extends Car implements SafetySystem, Infotainment, ADAS, ConnectedCar {

    public TopModel(String model) {
        super(model);
    }

    public void applyEmergencyBrake() {
        System.out.println("Emergency brake applied");
    }

    public void playMedia() {
        System.out.println("Playing premium music system");
    }

    public void enableAutoPilot() {
        System.out.println("AutoPilot enabled");
    }

    public void remoteStart() {
        System.out.println("Car started via mobile app");
    }

    public void showFeatures() {
        System.out.println("Top model with all features");
    }
}
