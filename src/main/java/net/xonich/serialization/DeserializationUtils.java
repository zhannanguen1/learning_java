package net.xonich.serialization;

public class DeserializationUtils {

    public static int readInt(byte[] nums, int offset) {

        int finalRes = 0;
        int firstByte = nums[offset];
        finalRes = finalRes | (firstByte << 24);

        int sec = nums[offset + 1];
        finalRes = finalRes | (sec << 16);

        int third = nums[offset + 2];
        finalRes = finalRes | (third << 8);

        finalRes = finalRes | (nums[offset + 3] & 0xFF);

        return finalRes;
    }

    public static String readString(byte[] buffer, int offset) {

        int length = readInt(buffer, offset); // длина строки
        byte[] receivedBytes = new byte[length]; // Создаем массив нужного размера
        System.arraycopy(buffer, offset + 4, receivedBytes, 0, length); // Копируем байты строки с 5 элемента (сдвиг на 4 байта, так как там была запись длины)

        return new String(receivedBytes);
    }

    public static Object deserialization(byte[] buffer) {

        byte typeCode = buffer[0]; // код типа
        if (typeCode == MessageType.MESSAGE_BAR.code) {

            int readOffset = 1;
            MessageBar messageBar = new MessageBar(
                    DeserializationUtils.readInt(buffer, readOffset),
                    DeserializationUtils.readInt(buffer, readOffset + 4),
                    DeserializationUtils.readInt(buffer, readOffset + 8)
            );
            return messageBar;
        } else if (typeCode == MessageType.MESSAGE_FOO.code) {
            String name = DeserializationUtils.readString(buffer, 1);
            return new MessageFoo(name);
        } else {
            throw new IllegalArgumentException("Неизвестный тип");
        }
    }
}
