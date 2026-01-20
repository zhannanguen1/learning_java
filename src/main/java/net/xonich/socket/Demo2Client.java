package net.xonich.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo2Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 50000);
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1000];
        int received = inputStream.read(buffer);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(buffer, 0, received);
        outputStream.write(buffer, 0, received);


    }
}
