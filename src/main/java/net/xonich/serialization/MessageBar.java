package net.xonich.serialization;

public class MessageBar {

    private int num;
    private int max;
    private int min;

    public MessageBar(int num, int max, int min) {
        this.num = num;
        this.max = max;
        this.min = min;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
