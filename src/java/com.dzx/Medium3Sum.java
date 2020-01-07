package com.dzx;

import java.util.*;

/*
    三数之和,排序固定一位,在右边双指针寻找
 */
public class Medium3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int lp, rp, last = nums[0]-1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (nums[i]==last) {
                continue;
            }
            lp = i+1;
            rp = nums.length - 1;
            while (lp < rp) {
                if (nums[lp] + nums[rp] == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    int left = nums[lp];
                    int right = nums[rp];
                    lp++;
                    rp--;
                    if (lp >= rp) {
                        break;
                    }
                    while (lp < rp && nums[lp] == left) {
                        lp++;
                    }
                    while (rp > lp && nums[rp] == right) {
                        rp--;
                    }
                }else if (nums[lp] + nums[rp] > -nums[i]) {
                    rp--;
                }else {
                    lp++;
                }
            }
            last = nums[i];
        }
        return result;
    }
}
