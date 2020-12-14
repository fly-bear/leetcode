package com.dzx;

import com.dzx.hard.MaximumSumBstInBinaryTree;

public class Main {
    public static void main(String[] args) {
	    MaximumSumBstInBinaryTree solution = new MaximumSumBstInBinaryTree();
	    TreeNode root = new TreeNode(1, new TreeNode(4,new TreeNode(2), new TreeNode(4)),
		    new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(6))));
	    int result = solution.maxSumBST(root);
        System.out.println(result);
    }
}