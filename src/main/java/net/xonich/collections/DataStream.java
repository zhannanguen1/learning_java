package net.xonich.collections;

public class DataStream {

    int value;
    int k;
    int count;


    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {

        if (num == value) {
            count++;
        } else {
            count = 0;
        }

        // либо return k <= count;
        if (count == k) {
            count = k - 1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        DataStream dataStream = new DataStream(1, 2);
        int[] nums = {4, 4, 4, 3};

//        for(int num : nums) {
//            System.out.println("dataStream.consec(num) = " + dataStream.consec(num));
//        }

        int[] nums2 = {1, 2, 1, 1, 1};
        for (int num : nums2) {
            System.out.println("dataStream.consec(num) = " + dataStream.consec(num));
        }
    }
}
