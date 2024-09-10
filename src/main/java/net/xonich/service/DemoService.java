package net.xonich.service;

public class DemoService {

    public static void main(String[] args) {

        SmartLamp lamp1 = new SmartLamp("lamp1");
        SmartLamp lamp2 = new SmartLamp("lamp2");


        SmartHome remoteController = new SmartHome();
        remoteController.connectDevice(lamp1);
        remoteController.connectDevice(lamp2);

        System.out.println(lamp1.getStatus());
        System.out.println(lamp2.getStatus());

        remoteController.turnOnAllLamps();

        System.out.println(lamp1.getStatus());
        System.out.println(lamp2.getStatus());

        remoteController.changeLightBrighter("lamp1",20);
        System.out.println(lamp1.getBrightness());
        System.out.println(lamp2.getBrightness());

    }
}
