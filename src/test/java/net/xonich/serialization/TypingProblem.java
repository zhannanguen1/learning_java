package net.xonich.serialization;

import org.junit.jupiter.api.Test;

import static net.xonich.serialization.SerializationUtils.writeInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypingProblem {

    public enum MessageType {

        MESSAGE_BAR(1, MessageBar.class),
        MESSAGE_FOO(2, MessageFoo.class);

        public final byte code;
        public final Class<?> clazz;

        MessageType(int code, Class<?> clazz) {
            this.code = (byte) code;
            this.clazz = clazz;
        }
    }

    @Test
    public void messageBarSerialization() {

        MessageBar messageBar = new MessageBar(12, 34, 56);
        byte[] buffer = new byte[1024];
        int off = 0;
        buffer[off++] = MessageType.MESSAGE_BAR.code;
        writeInt(messageBar.getNum(), buffer, off);
        off += 4;
        writeInt(messageBar.getMax(), buffer, off);
        off += 4;
        writeInt(messageBar.getMin(), buffer, off);
        off += 4;

        int readOffset = 1;
        MessageBar actual = new MessageBar(
                DeserializationUtils.readInt(buffer, readOffset),
                DeserializationUtils.readInt(buffer, readOffset + 4),
                DeserializationUtils.readInt(buffer, readOffset + 8)
        );

        assertEquals(messageBar.getNum(), actual.getNum());
        assertEquals(messageBar.getMax(), actual.getMax());
        assertEquals(messageBar.getMin(), actual.getMin());
    }

    @Test
    public void messageFooSerialization() {

        MessageFoo messageFoo = new MessageFoo("Test");

        byte[] buffer = new byte[1024];

        int off = 0;
        buffer[off] = MessageType.MESSAGE_FOO.code;

        byte[] stringBytes = messageFoo.getName().getBytes();

        writeInt(stringBytes.length, buffer, 1);
        System.arraycopy(stringBytes, 0, buffer, 5, stringBytes.length);


        int length = DeserializationUtils.readInt(buffer, 1);
        byte[] receivedBytes = new byte[length];
        System.arraycopy(buffer, 5, receivedBytes, 0, length);

        String string = new String(stringBytes);

        System.out.println(string);
        assertEquals(messageFoo.getName(), string);
    }
}
