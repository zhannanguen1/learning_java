package tasks;

import java.util.ArrayList;
import java.util.List;

public class StringToList {

    public static void split1() {

        String namesString = "Кирилл, Жанна, Мышь";

        List<String> names = new ArrayList<>();

        int start = 0;
        int finish = namesString.indexOf(',');

        while(finish > 0) {
            names.add(namesString.substring(start, finish));
            start = finish + 2;
            finish = namesString.indexOf(',', start);
        }
        names.add(namesString.substring(start));

        System.out.println(names);
    }

    public static void split2() {

        String namesString = "Кирилл, Жанна, Мышь";
        List<String> names = new ArrayList<>();
        String curName = "";
        int beginName = 0;
        int i = 0;

        while(i < namesString.length()) {
            if(namesString.charAt(i) != ',') {
                curName = curName + namesString.charAt(i);
                i++;
            } else {
                names.add(curName);
                curName = "";
                i = i + 2;
            }
        }
        names.add(curName);
        System.out.println(names);
    }
    
}
