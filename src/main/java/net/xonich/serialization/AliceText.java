package net.xonich.serialization;

import net.xonich.serialization.data.TextData;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AliceText {

    public static void sendTextData(int port, String firstName, String lastName) throws IOException {
        TextData textData = new TextData(firstName, lastName);
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();

        sendStringOverStream(outputStream, textData.getFirstName());
        sendStringOverStream(outputStream, textData.getLastName());
        outputStream.flush();


        socket.close();
        serverSocket.close();
    }

    public static void sendStringOverStream(OutputStream out, String str) throws IOException {
        byte[] bytes = str.getBytes();
        out.write(convertIntToBytes(bytes.length));
        out.write(bytes);
    }

    public static byte[] convertIntToBytes(int num) {
        byte[] nums = new byte[4];
        nums[0] = (byte) ((num >> 24) & 0xFF);
        nums[1] = (byte) ((num >> 16) & 0xFF);
        nums[2] = (byte) ((num >> 8) & 0xFF);
        nums[3] = (byte) (num & 0xFF);
        return nums;
    }
}
