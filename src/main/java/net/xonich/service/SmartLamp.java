package net.xonich.service;

public class SmartLamp extends SmartDevice {

    private int brightness;

    public SmartLamp(String name) {
        super(name);
        this.brightness = 50;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
