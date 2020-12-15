package com.dzx;

import com.dzx.easy.DegreeOfAnArray;
import com.dzx.hard.MaximumSumBstInBinaryTree;
import com.dzx.medium.CountNumberOfNiceSubarrays;

public class Main {
    public static void main(String[] args) {
	    DegreeOfAnArray solution = new DegreeOfAnArray();
	    int result = solution.findShortestSubArray(new int[]{1,2,2,3,1});
        System.out.println(result);
    }
}