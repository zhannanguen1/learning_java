package net.xonich.serialization;

import net.xonich.serialization.data.SimpleData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

    @Test
    public void testSimpleDataTransfer() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Void> serverDone = new CompletableFuture<>();
        int num = 1256;
        int moon = 7890;
        Thread serverThread = new Thread(() -> {

            try {
                Alice.startServerAndSend(num, moon);
                serverDone.complete(null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        serverThread.start();

        Thread.sleep(200);

        SimpleData simpleData = Bob.connectAndReceive();

        serverDone.get(5, TimeUnit.SECONDS);
        serverThread.join();

        assertEquals(num, simpleData.getNum());
        assertEquals(moon, simpleData.getMoon());
    }
}
