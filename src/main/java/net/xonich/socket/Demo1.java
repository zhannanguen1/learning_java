package net.xonich.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(50000); // принимает запросы на подключения
        Socket clientSocket = serverSocket.accept();

        System.out.println("Клиент подключился");

        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write("Hello world".getBytes());
        outputStream.flush(); // метод сразу отдает данные без задержки
        InputStream inputStream = clientSocket.getInputStream();

        byte[] buffer = new byte[1000];

        for (int i = 0; i < 2; i++) {
            int received = inputStream.read(buffer);
            System.out.println(new String(buffer, 0, received));
        }
        clientSocket.close();
        serverSocket.close();
    }
}
