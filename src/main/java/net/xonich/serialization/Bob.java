package net.xonich.serialization;

import net.xonich.serialization.data.SimpleData;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Bob {

    public static void main(String[] args) throws IOException {

        SimpleData simpleData = connectAndReceive();

        System.out.println(simpleData.getNum());
        System.out.println(simpleData.getMoon());
    }

    public static SimpleData connectAndReceive() throws IOException {

        Socket socket = new Socket("127.0.0.1", 50000);

        SimpleData simpleDataBob = new SimpleData(0, 0);

        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1000];
        int totalRead = 0;

        while (totalRead < 8) {
            int read = inputStream.read(buffer, totalRead, 8 - totalRead);
            if (read == -1) {
                throw new IOException("Поток закрыт, не удалось прочитать все данные");
            }
            totalRead += read;
        }

        byte[] numBytes = new byte[4];
        System.arraycopy(buffer, 0, numBytes, 0, 4);
        int receivedNum = readInt(numBytes);
        simpleDataBob.setNum(receivedNum);

        byte[] moonBytes = new byte[4];
        System.arraycopy(buffer, 4, moonBytes, 0, 4);
        int receivedMoon = readInt(moonBytes);
        simpleDataBob.setMoon(receivedMoon);

        socket.close();
        return simpleDataBob;
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
