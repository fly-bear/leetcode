package com.dzx;

import com.dzx.easy.EasyValiadPalinedromII;
import com.dzx.medium.LongestWordInDictionaryThroughDeleting;
import com.dzx.medium.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaximumSumOfConsecutiveSubarrays solution = new MaximumSumOfConsecutiveSubarrays();
        int result = solution.solve(new int[]{1,-2,3,10,-4,7,2,-5});
        System.out.println(result);
    }
}