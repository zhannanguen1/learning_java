package net.xonich.collections;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class StringFilterDemo {

    public static class StringFilter {

        private List<String> allWords;

        public StringFilter(List<String> allWords) {
            this.allWords = allWords;
        }

        public List<String> filterByFirstLetterRange(char start, char end) {

            return allWords.stream()
                    .filter(word -> word.charAt(0) >= start && word.charAt(0) <= end)
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TreeSet<String> words = new TreeSet<>(Arrays.asList(
                "apple", "banana", "computer", "dog", "elephant",
                "flower", "garden", "happy", "internet", "jungle",
                "knowledge", "language", "mountain", "notebook", "ocean",
                "pencil", "question", "rainbow", "sunshine", "travel", "client", "zoo"
        )) ;

        System.out.println("words.subSet(\"b\", \"w\") = " + words.subSet("b", "o"));


//        int chunkSize = (words.size() + 2) / 3;
//        List<List<String>> chunks = new ArrayList<>();
//        for (int i = 0; i < words.size(); i += chunkSize) {
//            chunks.add(words.subList(i, Math.min(i + chunkSize, words.size())));
//        }
//
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        List<Future<List<String>>> futures = new ArrayList<>();
//
//        for (List<String> chunk : chunks) {
//            Callable<List<String>> task = () -> new StringFilter(chunk).filterByFirstLetterRange('a', 'e');
//            futures.add(executor.submit(task));
//        }
//
//        List<String> result = new ArrayList<>();
//        for (Future<List<String>> future : futures) {
//            result.addAll(future.get());
//        }
//
//        result.forEach(System.out::println);
//
//        executor.shutdown();

    }
}
