package net.xonich.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Notebook {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(50000);
        Socket clientSocket = serverSocket.accept();

        OutputStream outputStream = clientSocket.getOutputStream();
        InputStream inputStream = clientSocket.getInputStream();

        outputStream.write("Укажите название файла: ".getBytes());
        outputStream.flush();

        byte[] buffer = new byte[50];

        int received = inputStream.read(buffer);
        String fileName = new String(buffer, 0, received).trim();
        OutputStream fos = new FileOutputStream("D:\\" + fileName + ".txt");

        outputStream.write(("Файл '" + fileName + "' создан. Введите текст для записи: ").getBytes());
        outputStream.flush();

        while (true) {
            received = inputStream.read(buffer);
            if (received <= 0) break;

            String text = new String(buffer, 0, received);

            fos.write(text.getBytes());
            fos.flush();
        }

        clientSocket.close();
        serverSocket.close();
    }
}
