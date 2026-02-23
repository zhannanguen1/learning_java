package net.xonich.serialization;

import net.xonich.serialization.data.TextData;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AliceText {

    public static void sendTextData(String firstName, String lastName) throws IOException {
        TextData textData = new TextData(firstName, lastName);
        ServerSocket serverSocket = new ServerSocket(60001);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();

        sendStringOverStream(outputStream, textData.getFirstName());
        sendStringOverStream(outputStream, textData.getLastName());
        outputStream.flush();


        socket.close();
        serverSocket.close();
    }

    public static void sendStringOverStream(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes();
        outputStream.write(convertIntToBytes(bytes.length));
        outputStream.write(bytes);
    }

    public static byte[] convertIntToBytes(int value) {
        byte[] nums = new byte[4];
        int firstByte = value & 0xFF_00_00_00;
        firstByte = firstByte >> 24;
        nums[0] = (byte) firstByte;

        int secByte = value & 0x00_FF_00_00;
        secByte = secByte >> 16;
        nums[1] = (byte) secByte;

        int thirdByte = value & 0x00_00_FF_00;
        thirdByte = thirdByte >> 8;
        nums[2] = (byte) thirdByte;

        nums[3] = (byte) value;

        return nums;
    }
}
