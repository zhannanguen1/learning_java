package net.xonich.homeWorks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringCompression {

    public static void main(String[] args) {

        char[] s = "aaarrrrr".toCharArray();
//        compression(s);
//        System.out.println(s);
        compression1(s);
        System.out.println(s);
//        compression2(s);
//        System.out.println(s);
//        compression3(Arrays.toString(s));
//        System.out.println(s);
//        compression4(toArr(Arrays.toString(s)));
//        System.out.println(s);
    }//aaak a3#k
    private static void compression1(char[] charArray) {
        char currentChar = charArray[0];
        int count = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == currentChar) {
                count++;
                charArray[i] = count > 2 ? '\0' : charArray[i];
            } else {
                if (count > 2) {
                    int newIndex = i - count + 1;
                    charArray[newIndex] = Character.forDigit(count, 10);
                }
                count = 1;
                currentChar = charArray[i];
            }
        }

        if (count > 2) {

            int newIndex = charArray.length - count + 1;
            charArray[newIndex] = Character.forDigit(count, 10);
        }

        int nextCharIndex = -1;
        int currCharIndex = 0;
        while (nextCharIndex < charArray.length && currCharIndex < charArray.length) {
            if (charArray[currCharIndex] == '\0') {
                nextCharIndex = nextCharIndex == -1 ? currCharIndex + 1 : nextCharIndex;

                if (nextCharIndex < charArray.length && charArray[nextCharIndex] != '\0') {
                    charArray[currCharIndex] = charArray[nextCharIndex];
                    charArray[nextCharIndex] = '\0';
                }
                nextCharIndex += 1;
            } else {
                currCharIndex += 1;
            }
        }
    }
// aaa
    private static void compression(char[] str) {
        char currentChar = str[0];
        int count = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == currentChar) { // текущий символ str[i] равен currentChar?
                count++;
            } else {
                if (count > 2) { // если больше 2х, то
                    int newIndex = i - count + 1; // устанавливается индекс, куда надо будет записать count
                    str[newIndex] = Character.forDigit(count, 10);
                    // сдвигаем все елементы после newIndex на count, заменяя ячейки на пробелы
                    for (int j = newIndex + 1; j + count - 2 < str.length; j++) {
                        str[j] = str[j + count - 2]; // a3arrrrr
                        str[j + count - 2] = '#';
                        System.out.println(str);
                    }
                    i = newIndex; // меняем i, чтобы цикл продолжилась с этого места
                }
                count = 1;
                currentChar = str[i]; // текущий символ
            }
        }

        if (count > 2) {
            int newIndex = str.length - count + 1;
            str[newIndex] = Character.forDigit(count, 10);
        }
    }

    public static void compression2(char[] str) {
        int writeIndex = 0; // индекс, по которому мы будем записывать сжатую версию строки.
        int count = 1; // счетчик, который будет хранить количество повторений текущего символа

        for (int i = 1; i < str.length; i++) {
            // если предыдущий символ равен текущей
            if (str[i - 1] == str[i]) {
                count++;
                // если одинаковых букв две
                if (count == 2) {
                    // если второй символ - это не последний символ в списке
                    if (i + 1 < str.length - 1) {
                        // если следующий символ не равен текущему
                        if (str[i] != str[i + 1]) {
                            str[writeIndex++] = str[i];
                        }
                    }
//                    else {
//                        writeIndex++;
//                    }
                }
            } else { // если предыдущий символ не равен текущему
                str[writeIndex++] = str[i - 1];
                if (count > 2) {
                    str[writeIndex++] = (char) (count + '0');
                }
                count = 1;
            }
        }
        // обрабатываем последний символ во входном массиве
        str[writeIndex++] = str[str.length - 1];
//        writeIndex++;
        if (count > 2) {
            str[str.length - 1] = (char) (count + '0'
            );
        } else {
            str[str.length - 1] = str[writeIndex++];
        }

        while (writeIndex < str.length) {
            str[writeIndex++] = '\0';
        }
    }


    public static String compression3(String str) {

        char letter = str.charAt(0);
        char temp;
        int count = 1;
        String newStr = "";

        for (int i = 1; i < str.length(); i++) {

            temp = str.charAt(i);

            if (temp != letter) {
                newStr = newStr + letter;
                newStr = (count > 1 ? newStr + count : newStr);
                letter = temp;
                count = 1;
            } else {
                count = count + 1;
            }
        }
        newStr = newStr.concat(String.valueOf(letter));
        newStr = (count > 1 ? newStr + count : newStr);
        return newStr;
    }

    public static String compression4(List<String> str) {
        int count = 1;
        String firstLetter = str.get(0);
        for (int i = 1; i < str.size(); i++) {
            String c = str.get(i);
            if (!Objects.equals(firstLetter, c)) {
                if (count > 1) {
                    str.set(i - 1, String.valueOf(count));
                    count = 1;
                }
                firstLetter = str.get(i);
            } else {
                str.set(i, "");
                count++;
            }
        }
        str.set(str.size() - 1, count > 1 ? String.valueOf(count) : str.get(str.size() - 1));
        return String.join("", str);
    }

    public static List<String> toArr(String str) {

        List<String> a = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            a.add(String.valueOf(str.charAt(i)));
        }
        return a;
    }

    /**
     * Input: string which consists of [a-z] symbols.
     * Output: string which repeated sequences of characters are compressed into sequence of repeated character
     * followed by number of how many times character was repeated.
     * Ex.1 aaabbbb -> a3b4
     * Ex.2 aaccbbb -> aaccb3 note: we don't replace aa to a2 because it would not yield any space benefit.
     * @return new length of str
     */
    public static int strCompression(char[] str) {
        int sqBeg = 0;
        int cur = 0;

        for (int i = 0; i <= str.length; i++) {
            if (i == str.length || str[sqBeg] != str[i]){//end of the seq
                int cnt = i - sqBeg;
                if (cnt > 2){
                    str[cur++] = str[sqBeg];
                    str[cur++] = (char) ('0' + cnt);
                } else {
                    for (int j = 0; j < cnt; j++) {
                        str[cur++] = str[sqBeg];
                    }
                }
                sqBeg = i;
            }
        }

        int res = cur;
//        while (cur < str.length) {
//            str[cur++] = '\0';
//        }

        return res;

    }
}
