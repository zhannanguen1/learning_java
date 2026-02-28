package net.xonich.serialization;

public class DeserializationUtils {

    public static int readInt(byte[] nums, int offset) {

        int finalRes = 0;
        int firstByte = nums[offset];
        finalRes = finalRes | (firstByte << 24);

        int sec = nums[offset + 1];
        finalRes = finalRes | (sec << 16);

        int third = nums[offset + 2];
        finalRes = finalRes | (third << 8);

        finalRes = finalRes | (nums[offset + 3] & 0xFF);

        return finalRes;
    }
}
