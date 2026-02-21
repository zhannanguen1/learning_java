package net.xonich.serialization.data;

public class SimpleData {

    private int num;
    private int moon;

    public SimpleData(int num, int moon) {
        this.num = num;
        this.moon = moon;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMoon() {
        return moon;
    }

    public void setMoon(int moon) {
        this.moon = moon;
    }
}
