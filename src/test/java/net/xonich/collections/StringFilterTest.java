package net.xonich.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFilterTest {

    @Test
    void testFilterByFirstLetterRange_SingleLetter() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        StringFilterDemo.StringFilter filter = new StringFilterDemo.StringFilter(words);

        List<String> result = filter.filterByFirstLetterRange('a', 'a');

        assertEquals(List.of("apple"), result);
    }


    @Test
    void testFilterByFirstLetterRange_MultipleLetters() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elephant", "client");
        StringFilterDemo.StringFilter filter = new StringFilterDemo.StringFilter(words);

        List<String> result = filter.filterByFirstLetterRange('a', 'c');

        assertEquals(Arrays.asList("apple", "banana", "cherry", "client"), result);
    }
}
