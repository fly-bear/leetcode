package com.dzx.medium;

import java.util.HashMap;
import java.util.Map;

/*
 *  四数相加问题ii,给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0
 *
 *  A[i]+B[j]放入 hashMap,遍历 C[m]+D[n]查找
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                if (hash.containsKey(a+b)) {
                    hash.put(a+b, hash.get(a+b)+1); //统计组合数次数
                }else {
                    hash.put(a+b, 1);
                }
            }
        }
        int result = 0;
        for (int c : C) {
            for (int d : D) {
                if (hash.containsKey(-c-d)) {
                    result += hash.get(-c-d);
                }
            }
        }
        return result;
    }
}
