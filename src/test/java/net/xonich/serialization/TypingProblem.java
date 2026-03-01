package net.xonich.serialization;

import org.junit.jupiter.api.Test;

import static net.xonich.serialization.DeserializationUtils.deserialization;
import static net.xonich.serialization.SerializationUtils.writeInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypingProblem {

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

        Object actual = deserialization(buffer);

        System.out.println(((MessageBar) actual).getNum());
        System.out.println(((MessageBar) actual).getMax());
        System.out.println(((MessageBar) actual).getMin());

        assertEquals(messageBar.getNum(),  ((MessageBar) actual).getNum());
        assertEquals(messageBar.getMax(),  ((MessageBar) actual).getMax());
        assertEquals(messageBar.getMin(), ((MessageBar) actual).getMin());
    }

    @Test
    public void messageFooSerialization() {

        MessageFoo messageFoo = new MessageFoo("Test");

        byte[] buffer = new byte[1024];

        int off = 0;
        buffer[off] = MessageType.MESSAGE_FOO.code;

        byte[] stringBytes = messageFoo.getName().getBytes(); // Массив байт строки "Test"

        writeInt(stringBytes.length, buffer, 1); // Записываем длину строки "Test", добавляем в буффер на место 1 (на 0 стоит тип)
        System.arraycopy(stringBytes, 0, buffer, 5, stringBytes.length); // добавляем в буффер текст на индекс 5

        Object actual = deserialization(buffer);

        System.out.println(((MessageFoo) actual).getName());
        assertEquals(messageFoo.getName(), ((MessageFoo) actual).getName());
    }
}
