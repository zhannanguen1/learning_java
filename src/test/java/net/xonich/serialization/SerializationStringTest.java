package net.xonich.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializationStringTest {

    @Test
    public void testOnlyFirstName() {

        String firstName = "Zhanna";
        byte[] bytes = firstName.getBytes();
        AliceText.convertIntToBytes(bytes.length);
        String readString = BobText.readString(bytes);

        assertEquals(firstName, readString);
    }

    @Test
    public void testNameLastName() {
        String firstName = "Harry";
        String lastName = "Potter";
        byte[] firstNameBytes = firstName.getBytes();
        byte[] lastNameBytes = lastName.getBytes();
        AliceText.convertIntToBytes(firstNameBytes.length);
        AliceText.convertIntToBytes(lastNameBytes.length);
        String readStringFN = BobText.readString(firstNameBytes);
        String readStingLN = BobText.readString(lastNameBytes);

        assertEquals(firstName, readStringFN);
        assertEquals(lastName, readStingLN);
    }

    @Test
    public void testEmpty() {

        String firstName = "";
        byte[] bytes = firstName.getBytes();
        AliceText.convertIntToBytes(bytes.length);
        String readString = BobText.readString(bytes);

        assertEquals(firstName, readString);
    }
}
