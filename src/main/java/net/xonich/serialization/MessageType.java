package net.xonich.serialization;

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
