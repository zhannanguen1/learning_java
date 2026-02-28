package net.xonich.serialization;

public class SerializationUtils {

    public static void writeInt(int value, byte[] buffer, int offset) {

        int firstByte = value & 0xFF_00_00_00; //0b1111_1111_0000_0000_0000_0000_0000_0000;
        firstByte = firstByte >> 24;
        buffer[offset] = (byte) firstByte;

        int secByte = value & 0x00_FF_00_00; //0b0000_0000_1111_1111_0000_0000_0000_0000;
        secByte = secByte >> 16;
        buffer[offset + 1] = (byte) secByte;

        int thirdByte = value & 0x00_00_FF_00; //0b0000_0000_0000_0000_1111_1111_0000_0000;
        thirdByte = thirdByte >> 8;
        buffer[offset + 2] = (byte) thirdByte;

        buffer[offset + 3] = (byte) value;
    }
}
