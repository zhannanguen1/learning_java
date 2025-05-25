package net.xonich.homeWorks;

class Solution {
    public static boolean isPalindrome(int x) {


        String a = "" + x;
        char[] arr = a.toCharArray();

        for (char c : arr) {

            if (c == arr[arr.length - 1]) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        isPalindrome(121);
    }
}
