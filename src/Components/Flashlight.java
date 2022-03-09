package Components;

public class Flashlight extends Item {
    private boolean isFlashOn;

    public Flashlight(int price) {
        super("Flashlight", price);
    }

    public boolean isFlashOn() {
        return isFlashOn;
    }

    public void switchFlash() {
        isFlashOn = !isFlashOn;
    }
}
