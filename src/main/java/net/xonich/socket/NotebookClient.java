package net.xonich.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NotebookClient {

    private Socket socket;
    private OutputStream outputStream;

    public void connect(String host, int port) throws IOException {

        socket = new Socket("127.0.0.1", 50000);
        outputStream = socket.getOutputStream();
    }

    public void sendFileName(String fileName) throws IOException, InterruptedException {

        outputStream.write(fileName.getBytes());
        outputStream.flush();

        Thread.sleep(100);
    }

    public void sendMessages() throws IOException {

        outputStream.write("ф".repeat(1000).getBytes());
        outputStream.flush();

        outputStream.write("и\n".getBytes());
        outputStream.flush();

        outputStream.write("ф".repeat(1000).getBytes());
        outputStream.flush();

        outputStream.write("и\n".getBytes());
        outputStream.flush();
    }

    public void disconnect() throws IOException {

        socket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        NotebookClient client = new NotebookClient();
        client.connect("127.0.0.1", 50000);
        client.sendFileName("Testing");
        client.sendMessages();
        client.disconnect();
    }
}
