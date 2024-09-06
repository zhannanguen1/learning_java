package net.xonich.service;

public class DemoService {

    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp("lamp");
        SmartHome remoteController = new SmartHome();
        remoteController.connectDevice(lamp);
//        remoteController.turnOnLamp();
        SmartDevice smartDevice = new SmartDevice("Socket");
        smartDevice.turnOff();
        System.out.println(lamp.getStatus());


    }
}
