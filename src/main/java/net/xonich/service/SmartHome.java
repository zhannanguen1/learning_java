package net.xonich.service;

import java.util.HashMap;
import java.util.Map;

public class SmartHome {

    private final Map<String, SmartDevice> connectedDevices;

    public SmartHome() {
        this.connectedDevices = new HashMap<>();
    }

    public void connectDevice(SmartDevice device) {
        connectedDevices.put(device.getDeviceName(), device);
    }

    public void disconnectDevice(String deviceName) {
        connectedDevices.remove(deviceName);
    }

    /**
     * Включает все подключенные лампы
     */
    public void turnOnAllLamps() {
        for (SmartDevice device : connectedDevices.values()) {
            if (device instanceof SmartLamp) {
                device.turnOn();
            }
        }
    }

    public void turnOffAllLamp() {
        for (SmartDevice device : connectedDevices.values()) {
            if (device instanceof SmartLamp) {
                device.turnOff();
            }
        }
    }

    public void changeLightBrighter(String lampName, int brightness) {
        SmartDevice device = connectedDevices.get(lampName);
        if (device instanceof SmartLamp) {
            SmartLamp lamp = (SmartLamp) device;
            lamp.setBrightness(brightness);
        }
    }
}
