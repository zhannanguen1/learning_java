package net.xonich.service;

public class SmartDevice {
    private String deviceName;
    private boolean status;

    public SmartDevice(String deviceName, boolean status) {
        this.deviceName = deviceName;
        this.status = status;
    }

    public SmartDevice(String deviceName) {
        this(deviceName, false);
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getStatus() {
        return status;
    }

    /**
     * Включает устройство.
     * @return {@code True}, если включение было успешное, иначе {@code false}.
     */
    public boolean turnOn() {
        if (getStatus()) {
            return false;
        } else {
            status = true;
            return true;
        }
    }

    /**
     * Выключает устройство.
     * @return {@code True}, если выключение было успешное, иначе {@code false}.
     */
    public boolean turnOff() {
        if (!getStatus()) {
            return false;
        } else {
            status = false;
            return true;
        }
    }
}
