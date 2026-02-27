package net.xonich.homeWorks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median;

        int[] sortedArray = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .toArray();

        System.out.println(Arrays.toString(sortedArray));

        if (sortedArray.length % 2 != 0) {
            median = sortedArray[sortedArray.length / 2];
        } else {
            int one = sortedArray[sortedArray.length / 2 - 1];
            int two = sortedArray[sortedArray.length / 2];
            median = (one + two) / 2.0;
        }

        System.out.println(median);
    }
}
