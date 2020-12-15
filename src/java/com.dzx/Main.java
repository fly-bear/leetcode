package com.dzx;

import com.dzx.hard.MaximumSumBstInBinaryTree;
import com.dzx.medium.CountNumberOfNiceSubarrays;

public class Main {
    public static void main(String[] args) {
	    CountNumberOfNiceSubarrays solution = new CountNumberOfNiceSubarrays();
	    TreeNode root = new TreeNode(1, new TreeNode(4,new TreeNode(2), new TreeNode(4)),
		    new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(6))));
	    int result = solution.numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
        System.out.println(result);
    }
}