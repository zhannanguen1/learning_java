package net.xonich.serialization;

import net.xonich.serialization.data.SimpleData;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Alice {

    public static void startServerAndSend(int num, int moon) throws IOException {

        SimpleData simpleDataAlice = new SimpleData(num, moon);

        ServerSocket serverSocket = new ServerSocket(60000);
        Socket socket = serverSocket.accept();

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(writeInt(simpleDataAlice.getNum()));
        outputStream.write(writeInt(simpleDataAlice.getMoon()));
        outputStream.flush();

        socket.close();
        serverSocket.close();
    }

    public static byte[] writeInt(int num) {

        byte[] nums = new byte[4];
        int firstByte = num & 0xFF_00_00_00; //0b1111_1111_0000_0000_0000_0000_0000_0000;
        firstByte = firstByte >> 24;
        nums[0] = (byte) firstByte;

        int secByte = num & 0x00_FF_00_00; //0b0000_0000_1111_1111_0000_0000_0000_0000;
        secByte = secByte >> 16;
        nums[1] = (byte) secByte;

        int thirdByte = num & 0x00_00_FF_00; //0b0000_0000_0000_0000_1111_1111_0000_0000;
        thirdByte = thirdByte >> 8;
        nums[2] = (byte) thirdByte;

        nums[3] = (byte) num;

        return nums;
    }
}
