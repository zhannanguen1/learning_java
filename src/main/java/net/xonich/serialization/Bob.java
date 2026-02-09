package net.xonich.serialization;

import net.xonich.serialization.data.SimpleData;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Bob {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 50000);

        SimpleData simpleDataBob = new SimpleData(0);

        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1000];

        int received = inputStream.read(buffer);

        System.out.println(readInt(buffer));
    }

    public static int readInt(byte[] nums) {

        int finalRes = 0;
        int firstByte = nums[0];
        finalRes = finalRes | (firstByte << 24);

        int sec = nums[1];
        finalRes = finalRes | (sec << 16);

        int third = nums[2];
        finalRes = finalRes | (third << 8);

        finalRes = finalRes | (nums[3] & 0xFF);

        return finalRes;
    }
}
