package net.xonich.serialization;

import net.xonich.serialization.data.TextData;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class BobText {

    public static void main(String[] args) throws IOException {

        receiveTextData("127.0.0.1", 60001);
    }

    public static TextData receiveTextData(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        TextData textData = new TextData();

        try (InputStream inputStream = socket.getInputStream()) {
            String firstName = receiveStringFromStream(inputStream);
            String lastName = receiveStringFromStream(inputStream);

            textData.setFirstName(firstName);
            textData.setLastName(lastName);

            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);
        }

        socket.close();
        return textData;
    }

    public static String receiveStringFromStream(InputStream inputStream) throws IOException {
        byte[] lengthBytes = new byte[4];
        int totalRead = 0;

        while (totalRead < 4) {
            int read = inputStream.read(lengthBytes, totalRead, 4 - totalRead);
            if (read == -1) {
                throw new IOException("Поток закрыт, не удалось прочитать длину строки");
            }
            totalRead += read;
        }

        int length = readInt(lengthBytes);

        byte[] stringBytes = new byte[length];
        totalRead = 0;

        while (totalRead < length) {
            int read = inputStream.read(stringBytes, totalRead, length - totalRead);
            if (read == -1) {
                throw new IOException("Поток закрыт, не удалось прочитать строку");
            }
            totalRead += read;
        }


        return readString(stringBytes);
    }

    public static String readString(byte[] bytes) {
        return new String(bytes);
    }

    public static int readInt(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return buffer.getInt();
    }
}
