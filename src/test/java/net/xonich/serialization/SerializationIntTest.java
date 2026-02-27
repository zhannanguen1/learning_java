package net.xonich.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializationIntTest {

    @Test
    void testWriteAndReadInt() {
        int originalValue = 1256;
        byte[] bytes = Alice.writeInt(originalValue);
        int result = Bob.readInt(bytes);
        assertEquals(originalValue, result);
    }

    @Test
    void testWriteAndReadIntNegative() {
        int originalValue = -500;
        byte[] bytes = Alice.writeInt(originalValue);
        int result = Bob.readInt(bytes);
        assertEquals(originalValue, result);
    }

    @Test
    void testWriteAndReadIntZero() {
        int originalValue = 0;
        byte[] bytes = Alice.writeInt(originalValue);
        int result = Bob.readInt(bytes);
        assertEquals(originalValue, result);
    }

    @Test
    void testMultipleValues() {
        int num = 1256;
        int moon = 7890;

        byte[] numBytes = Alice.writeInt(num);
        byte[] moonBytes = Alice.writeInt(moon);

        int receivedNum = Bob.readInt(numBytes);
        int receivedMoon = Bob.readInt(moonBytes);

        assertEquals(num, receivedNum);
        assertEquals(moon, receivedMoon);
    }
}
