package net.xonich.homeWorks;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    @ParameterizedTest
    @CsvSource({
            "aaac,       a3c",
            "aaabbbc,    a3b3c",
            "abc,        abc",
            "aaaaaaaa,   a8"
    })
    public void shouldCompressStrings(String input, String expected){
        char[] str = input.toCharArray();
        int len = StringCompression.strCompression(str);

        assertEquals(expected, new String(str, 0, len));
    }




}