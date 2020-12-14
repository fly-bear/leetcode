package com.dzx;

import com.dzx.easy.EasyValiadPalinedromII;
import com.dzx.medium.DeleteNodeInABst;
import com.dzx.medium.LongestTurbulentSubarray;
import com.dzx.medium.LongestWordInDictionaryThroughDeleting;
import com.dzx.medium.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	    DeleteNodeInABst solution = new DeleteNodeInABst();
	    TreeNode root = new TreeNode(1, null, new TreeNode(2));
	    TreeNode result = solution.deleteNode(root, 1);
        System.out.println(result);
    }
}