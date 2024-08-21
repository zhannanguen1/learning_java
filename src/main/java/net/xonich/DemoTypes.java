package net.xonich;

public class DemoTypes {
    public static void main(String[] args) {
        //8 primitive + 1 ref type
        //boolean - 1 byte
        //integers
        //byte - 1 byte (-128 ... +127 | -2^7 .. 0 .. + 2^7-1)
        //short - 2 byte (-32568 .. 32567 | -2^15 .. +2^15-1)
        //int - 4 byte (-2^31 ... +2^31 - 1)
        //long - 8 byte (-2^63 .. +2^63-1)
        //char - 2 byte (0 ... 65355 | 0 ... 2^16 - 1)

        //floats
        //float - 4 byte IEEE 754
        //double - 8 byte

        char x = 65;

        System.out.println(x);
        x += 10;

        System.out.println(x);

        Object o = null;//size - 64 bit = 8 byte ****
        //real world application can use 32 bit ref in 64 bit JVM
    }
}
