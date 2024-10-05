package net.xonich.homeWorks;

public class stringCompression {

    public static void main(String[] args) {

        System.out.println(compression("abbaaarrrrru"));
    }

    public static String compression(String str) {

        char letter = str.charAt(0);
        char temp;
        int count = 1;
        String newStr = "";

        for (int i = 1; i < str.length(); i++) {

            temp = str.charAt(i);

            if (temp != letter) {
                newStr = newStr.concat(String.valueOf(letter));
                newStr = (count > 1 ? newStr.concat(String.valueOf(count)) : newStr);
                letter = temp;
                count = 1;
            } else {
                count = count + 1;
            }
        }
        newStr = newStr.concat(String.valueOf(letter));
        newStr = (count > 1 ? newStr.concat(String.valueOf(count)) : newStr);
        return newStr;
    }
}
