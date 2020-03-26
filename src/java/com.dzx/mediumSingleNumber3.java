package com.dzx;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 1、两两异或，最终得到只出现一次的两个数字 x、y 的异或结果 mask，为 1 的位就是两个数不同的地方
 * 2、mask 与 -mask 按位与操作，可以保留最右边的 1，得到 diff（位运算以补码方式进行）
 * 3、每个数字再与 diff 相与，按被保留的那位的值,可以分成两组，一组含 x，另一组含 y
 * 4、对其中一组两两异或，得到 x
 * 5、x 与 mask 异或，得到 y
 */
public class mediumSingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        int mask = 0;
        int diff;
        for (int num : nums) {
            mask ^= num; //最后结果是 x^y, x 和 y 的不同位都是 1
        }
        diff = mask & (-mask); // 保留最右的一位 1
        for (int num : nums) {
            if ((num & diff) == 0) {
                x ^= num;
            }
        }
        return new int[]{x, x^mask};
    }
}
