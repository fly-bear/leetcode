package com.dzx;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Medium3Sum medium3Sum = new Medium3Sum();
        long start = System.currentTimeMillis();
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> result = medium3Sum.threeSum(nums);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(result);
    }
}