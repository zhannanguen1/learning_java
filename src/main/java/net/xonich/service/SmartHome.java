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
        connectedDevices.get("lamp").turnOn();
    }

    public void turnOffLamp() {
        connectedDevices.get("lamp").turnOff();
    }

//    public void makeLightBrighter(String device) {
//        connectedDevices.get("lamp").setBrightness(100);
//    }
}
