package net.xonich.homeWorks;

public class IsPalindrome {

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        String a = "" + x;
        char[] arr = a.toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println("isPalindrome(121) = " + isPalindrome(121));
        System.out.println("isPalindrome(-121) = " + isPalindrome(-121));
        System.out.println("isPalindrome(10) = " + isPalindrome(10));
        System.out.println("isPalindrome(1001) = " + isPalindrome(1001));
    }
}
