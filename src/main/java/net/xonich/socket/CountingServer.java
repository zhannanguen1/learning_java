package net.xonich.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CountingServer {

    private static int clientCount = 0;
    private static final int MAX_COUNT = 100;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(50000);
        while (clientCount < MAX_COUNT) {

            Socket clientSocket = serverSocket.accept();
            clientCount++;
            OutputStream outputStream = clientSocket.getOutputStream();
            String message = "Вы клиент №" + clientCount + " из " + MAX_COUNT + "\n";
            outputStream.write(message.getBytes());
            outputStream.flush();
            clientSocket.close();
        }

        serverSocket.close();
    }
}
